package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class IndexResponse {

    @ApiModelProperty(value = "产业重点企业")
    private Integer cyzdqy;

    @ApiModelProperty(value = "专精特新企业")
    private Integer zjtxqy;

    @ApiModelProperty(value = "产业核心技术领域企业")
    private Integer cyhxjsly;

    @ApiModelProperty(value = "产业现有人才")
    private Integer cyxyrc;

    @ApiModelProperty(value = "产业盯引人才")
    private Integer cydyrc;

    @ApiModelProperty(value = "成功匹配人才")
    private Integer cgpprc;

    private List<MapResponse> map;

}
