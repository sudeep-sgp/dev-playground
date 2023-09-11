package com.ququads.stockexplorer.controller;

import com.ququads.stockexplorer.dto.StockRecommendation;
import com.ququads.stockexplorer.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/stocks")
@AllArgsConstructor
public class StockRecommendationController {

    private StockService stockService;

    @GetMapping("/recommendations")
    public Mono<ResponseEntity<StockRecommendation>> getUserById(@RequestParam String symbol) {
        return stockService.getRecommendations(symbol)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
