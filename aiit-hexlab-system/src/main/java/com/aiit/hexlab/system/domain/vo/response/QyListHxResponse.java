package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QyListHxResponse {

    private Long id;

    @ApiModelProperty(value = "企业名称")
    private String name;

    @ApiModelProperty(value = "产业领域")
    private String cyly;

    @ApiModelProperty(value = "企业类型")
    private String qylx;

}
