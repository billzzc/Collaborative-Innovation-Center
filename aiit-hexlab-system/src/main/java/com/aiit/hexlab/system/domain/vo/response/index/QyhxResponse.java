package com.aiit.hexlab.system.domain.vo.response.index;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class QyhxResponse {

    @ApiModelProperty(value = "企业名称")
    private String qymc;

    @ApiModelProperty(value = "企业标签")
    private List<String> qybq;

    @ApiModelProperty(value = "所属行业")
    private String sshy;

    @ApiModelProperty(value = "产品类别")
    private String cplb;

    @ApiModelProperty(value = "核心技术")
    private List<String> hxjs;

    @ApiModelProperty(value = "领军技术人才")
    private String ljjsrc;

    @ApiModelProperty(value = "推荐人才")
    private List<String> tjrc;
}
