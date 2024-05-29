package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class KcptResponse {

    private Long id;

    @ApiModelProperty(value = "平台名称")
    private String ptmc;

    @ApiModelProperty(value = "依托机构")
    private String ytjg;

    @ApiModelProperty(value = "产业领域")
    private String cyly;

    @ApiModelProperty(value = "平台类型 ")
    private String ptlx;

}
