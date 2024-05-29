package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CyqyResponse {

    @ApiModelProperty(value = "专精特新企业")
    private Integer zjtxqy;

    @ApiModelProperty(value = "小巨人")
    private Integer xjr;

    @ApiModelProperty(value = "国家科技型")
    private Integer gjkjx;

    @ApiModelProperty(value = "瞪羚企业")
    private Integer dlqy;

    @ApiModelProperty(value = "国家高新技术")
    private Integer gjgxjs;

    @ApiModelProperty(value = "企业列表")
    private List<QyResponse> qy;

}
