package com.ququads.stockexplorer.service;

import com.ququads.stockexplorer.dto.Quote;
import com.ququads.stockexplorer.dto.StockRecommendation;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
@Service
@Slf4j
public class StockServiceImpl implements StockService {
    /**
     * @param symbol
     * @return
     */
    private final KafkaTemplate<String, Quote> kafkaTemplate;

    @Value(value = "${kafka.topic.stock-recommendation}")
    private final String STOCK_TOPIC = null;

    public StockServiceImpl(KafkaTemplate<String, Quote> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public Mono<StockRecommendation> getRecommendations(@NonNull String symbol) {
        List<Quote> quotes = null;
        Mono<StockRecommendation> stockRecommendationMono = WebClient.create()
                .get()
                .uri("https://yh-finance.p.rapidapi.com/stock/v2/get-recommendations?symbol=" + symbol)
                .header("X-RapidAPI-Key", "BaGdT2IWvDmsh8SU7wA1RiHuPd1Op1Y9ohojsnU03DpxL57Q0Y")
                .header("X-RapidAPI-Host", "yh-finance.p.rapidapi.com")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(StockRecommendation.class);

        stockRecommendationMono.subscribe(recommendation -> {
            recommendation.getFinance()
                    .getResult().forEach(result -> {
                        result.getQuotes().forEach(quote -> {
                            kafkaTemplate.send(STOCK_TOPIC, quote);
                            log.info(quote.getShortName());
                            System.out.println("Quote" + quote.getShortName());
                        });

                    });
        });
        return stockRecommendationMono;
    }
}
