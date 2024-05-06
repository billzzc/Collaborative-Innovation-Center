package com.aiit.hexlab.system.domain.vo.response.index;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DtzbResponse {

    @ApiModelProperty(value = "数量", notes = "这个字段只有在人才在不同国家数量分布的时候会返回")
    private Integer sl;

    @ApiModelProperty(value = "经度")
    private String lgt;

    @ApiModelProperty(value = "纬度")
    private String lat;

    @ApiModelProperty(value = "名称")
    private String mc;

    @ApiModelProperty(value = "主要领域", notes = "这个字段只会在产业布局图中会展示")
    private String zyly;

    @ApiModelProperty(value = "核心技术", notes = "这个字段只会在产业布局图中会展示")
    private String hxjs;

    @ApiModelProperty(value = "类型", notes = "这个字段只会在企业布局图中会展示，0表示重点企业，1表示产业园区")
    private String type;
}
