package com.aiit.hexlab.system.domain.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PieResponse {

    private String name;

    private Integer value;

    private Double percent;

    public PieResponse(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

}
