package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CyyqhxResponse {

    @ApiModelProperty(value = "园区名称")
    private String name;

    @ApiModelProperty(value = "产业领域")
    private String cyly;

    @ApiModelProperty(value = "产业方向")
    private String cyfx;

    @ApiModelProperty(value = "重点行业")
    private String zdhy;

    @ApiModelProperty(value = "细分赛道")
    private String xfsd;

    @ApiModelProperty(value = "土地性质")
    private String tdxz;

    @ApiModelProperty(value = "重点企业")
    private String zdqy;

    @ApiModelProperty(value = "推荐人才")
    private List<RcListHxResponse> tjrc;

}
