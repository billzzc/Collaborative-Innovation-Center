package com.aiit.hexlab.system.domain.vo.response.index;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GwhxResponse {

    @ApiModelProperty(value = "岗位职责")
    private String gwzz;

    @ApiModelProperty(value = "岗位名称")
    private String gwmc;

    @ApiModelProperty(value = "核心技术")
    private String hxjs;

    @ApiModelProperty(value = "产业领域")
    private String cyly;

    @ApiModelProperty(value = "岗位缺口数量")
    private Integer gwqksl;

    @ApiModelProperty(value = "推荐人才")
    private String tjrc;

}
