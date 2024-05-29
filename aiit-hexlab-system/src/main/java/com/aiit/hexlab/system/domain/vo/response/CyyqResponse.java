package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CyyqResponse {

    private Long id;

    @ApiModelProperty(value = "园区名称")
    private String yqmc;

    @ApiModelProperty(value = "产业领域")
    private String cyly;

    @ApiModelProperty(value = "产业方向")
    private String cyfx;

}
