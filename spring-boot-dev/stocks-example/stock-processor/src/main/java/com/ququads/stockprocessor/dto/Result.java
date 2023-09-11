package com.ququads.stockprocessor.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Result {
    private Long count;
    private List<Quote> quotes;
}
