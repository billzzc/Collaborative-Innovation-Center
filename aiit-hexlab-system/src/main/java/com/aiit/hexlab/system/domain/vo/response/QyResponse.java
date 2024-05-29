package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QyResponse {

    private Long id;

    @ApiModelProperty(value = "企业")
    private String qy;

    @ApiModelProperty(value = "企业类型")
    private String qylx;

    @ApiModelProperty(value = "产品类别")
    private String cplb;

}
