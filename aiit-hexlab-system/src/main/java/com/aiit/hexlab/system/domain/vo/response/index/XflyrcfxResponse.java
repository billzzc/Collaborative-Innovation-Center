package com.aiit.hexlab.system.domain.vo.response.index;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class XflyrcfxResponse {

    @ApiModelProperty(value = "x轴")
    private String x;

    @ApiModelProperty(value = "y轴")
    private Integer y;

}
