package com.aiit.hexlab.system.domain.vo.response.index;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CyrcxqResponse {

    @ApiModelProperty(value = "x轴")
    private String x;

    @ApiModelProperty(value = "需求人数")
    private Integer xqrs;

    @ApiModelProperty(value = "发布职位数")
    private Integer fbzws;

}
