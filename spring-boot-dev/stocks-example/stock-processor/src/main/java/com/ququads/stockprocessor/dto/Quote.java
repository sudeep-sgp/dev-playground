package com.ququads.stockprocessor.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Quote {

    private Boolean cryptoTradeable;
    private String customPriceAlertConfidence;
    private Boolean esgPopulated;
    private String exchange;
    private Long exchangeDataDelayedBy;
    private String exchangeTimezoneName;
    private String exchangeTimezoneShortName;
    private Long firstTradeDateMilliseconds;
    private String fullExchangeName;
    private Long gmtOffSetMilliseconds;
    private String language;
    private String market;
    private String marketState;
    private Double postMarketChange;
    private Double postMarketChangePercent;
    private Double postMarketPrice;
    private Long postMarketTime;
    private Long priceHint;
    private String quoteSourceName;
    private String quoteType;
    private String region;
    private Double regularMarketChange;
    private Double regularMarketChangePercent;
    private Double regularMarketPreviousClose;
    private Double regularMarketPrice;
    private Long regularMarketTime;
    private String shortName;
    private Long sourceInterval;
    private String symbol;
    private Boolean tradeable;
    private Boolean triggerable;
    private String typeDisp;

}
