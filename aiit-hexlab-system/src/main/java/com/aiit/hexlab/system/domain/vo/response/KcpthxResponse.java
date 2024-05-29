package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class KcpthxResponse {

    @ApiModelProperty(value = "平台名称")
    private String name;

    @ApiModelProperty(value = "平台类型")
    private String ptlx;

    @ApiModelProperty(value = "产业领域")
    private String cyly;

    @ApiModelProperty(value = "依托机构")
    private String ytjg;

    @ApiModelProperty(value = "核心技术")
    private String hxjs;

    @ApiModelProperty(value = "推荐人才")
    private List<RcListHxResponse> tjrc;

}