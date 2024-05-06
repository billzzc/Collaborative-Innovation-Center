package com.aiit.hexlab.system.domain.vo.response.talents;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class KcptResponse {

    @ApiModelProperty(value = "项目名称")
    private String ptmc;

    @ApiModelProperty(value = "产业领域")
    private String cyly;

    @ApiModelProperty(value = "平台类型")
    private String ptlx;

}
