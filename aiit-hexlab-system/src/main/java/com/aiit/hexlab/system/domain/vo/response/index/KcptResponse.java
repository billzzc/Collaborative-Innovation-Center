package com.aiit.hexlab.system.domain.vo.response.index;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class KcptResponse {

    @ApiModelProperty(value = "平台名称")
    private String ptmc;

    @ApiModelProperty(value = "核心技术")
    private String hxjs;

    @ApiModelProperty(value = "领域")
    private String ly;

    @ApiModelProperty(value = "依托机构")
    private String ytjg;

    @ApiModelProperty(value = "类型")
    private String lx;

    @ApiModelProperty(value = "推荐人才 ")
    private List<String> tjrc;

}
