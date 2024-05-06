package com.aiit.hexlab.system.domain.vo.response.index;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PieResponse {

    @ApiModelProperty(value = "名称")
    private String mc;

    @ApiModelProperty(value = "占比")
    private Double zb;

    @ApiModelProperty(value = "数量")
    private int sl;
}
