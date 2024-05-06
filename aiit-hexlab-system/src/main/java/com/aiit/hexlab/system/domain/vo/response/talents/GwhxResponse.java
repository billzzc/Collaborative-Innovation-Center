package com.aiit.hexlab.system.domain.vo.response.talents;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class GwhxResponse {

    @ApiModelProperty(value = "岗位名称")
    private String gwmc;

    @ApiModelProperty(value = "产业领域")
    private String cyly;

    @ApiModelProperty(value = "核心技术")
    private String hxjs;

    @ApiModelProperty(value = "岗位详情")
    private String gwxq;

    @ApiModelProperty(value = "推荐人才")
    private List<String> tjrc;

}
