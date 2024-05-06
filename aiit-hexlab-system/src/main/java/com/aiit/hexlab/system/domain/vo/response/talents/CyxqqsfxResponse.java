package com.aiit.hexlab.system.domain.vo.response.talents;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CyxqqsfxResponse {

    @ApiModelProperty(value = "x轴")
    private String x;

    @ApiModelProperty(value = "y轴")
    private Integer y;

}
