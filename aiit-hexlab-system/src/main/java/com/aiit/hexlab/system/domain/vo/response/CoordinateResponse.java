package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CoordinateResponse {

    @ApiModelProperty(value = "x轴")
    private String x;

    @ApiModelProperty(value = "y轴")
    private Integer y;

}
