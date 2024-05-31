package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class QyResponse {

    private Long id;

    @ApiModelProperty(value = "企业")
    private String qy;

    @ApiModelProperty(value = "重点方向")
    private String zdfx;

    @ApiModelProperty(value = "主营产品")
    private String zycp;

}
