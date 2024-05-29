package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class QyhxResponse {

    @ApiModelProperty(value = "企业名称")
    private String name;

    @ApiModelProperty(value = "企业类别")
    private String qylb;

    @ApiModelProperty(value = "产业领域")
    private String cyly;

    @ApiModelProperty(value = "产业方向")
    private String cyfx;

    @ApiModelProperty(value = "核心技术")
    private String hxjs;

    @ApiModelProperty(value = "领军技术人才")
    private String ljjsrc;

    @ApiModelProperty(value = "推荐人才")
    private List<RcListHxResponse> tjrc;

}
