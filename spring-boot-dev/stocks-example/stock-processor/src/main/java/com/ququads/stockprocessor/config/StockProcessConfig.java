package com.ququads.stockprocessor.config;

import com.ququads.stockprocessor.dto.Quote;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Slf4j
@Configuration
public class StockProcessConfig {

    @Bean
    public Function<KStream<String, Quote>, KStream<String, Quote>> stockProcessor() {
        return quoteStream -> quoteStream.filter((key, quote) -> {
            if (!quote.getTriggerable()) {
                log.info(quote.getShortName() + " is not triggerable");
            }
            else {
                log.info(quote.getShortName() + " is triggerable");
            }
            return quote.getTriggerable();
        });
    }
}
