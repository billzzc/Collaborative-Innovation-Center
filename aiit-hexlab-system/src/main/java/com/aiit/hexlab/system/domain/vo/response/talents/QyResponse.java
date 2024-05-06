package com.aiit.hexlab.system.domain.vo.response.talents;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QyResponse {

    @ApiModelProperty(value = "企业名称")
    private String qymc;

    @ApiModelProperty(value = "企业类型")
    private String qylX;

    @ApiModelProperty(value = "产品类别")
    private String cplb;

}
