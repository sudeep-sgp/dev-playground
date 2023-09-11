
package com.ququads.stockexplorer.dto;

import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Finance {
    private Object error;
    private List<Result> result;

}
