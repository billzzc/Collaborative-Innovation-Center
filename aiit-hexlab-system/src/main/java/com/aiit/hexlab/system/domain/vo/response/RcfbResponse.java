package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RcfbResponse {

    private Integer a;

    private Integer b;

    private Integer c;

    private Integer d;

    private Integer e;

    private Integer f;

    @ApiModelProperty(value = "年份")
    private String nf;

}
