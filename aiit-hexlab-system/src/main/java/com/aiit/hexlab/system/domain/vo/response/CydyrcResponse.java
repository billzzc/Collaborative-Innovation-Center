package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class CydyrcResponse {

    @ApiModelProperty(value = "年龄分布")
    private List<PieResponse> nlfb;

    @ApiModelProperty(value = "学位分布")
    private List<PieResponse> xwfb;

    @ApiModelProperty(value = "人才分布")
    private List<RcfbResponse> rcfb;

}
