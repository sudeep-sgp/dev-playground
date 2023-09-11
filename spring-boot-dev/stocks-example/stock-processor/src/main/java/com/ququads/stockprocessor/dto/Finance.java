
package com.ququads.stockprocessor.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Finance {
    private Object error;
    private List<Result> result;

}
