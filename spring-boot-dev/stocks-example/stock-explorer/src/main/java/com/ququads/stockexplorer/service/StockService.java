package com.ququads.stockexplorer.service;

import com.ququads.stockexplorer.dto.StockRecommendation;
import reactor.core.publisher.Mono;

public interface StockService {
    Mono<StockRecommendation> getRecommendations(String symbol);
}
