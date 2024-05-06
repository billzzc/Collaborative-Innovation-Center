package com.aiit.hexlab.system.domain.vo.response.index;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class XmhxResponse {

    @ApiModelProperty(value = "项目名称")
    private String xmmc;

    @ApiModelProperty(value = "项目状态")
    private String xmzt;

    @ApiModelProperty(value = "项目类型")
    private String xmlx;

    @ApiModelProperty(value = "产业领域")
    private String cyly;

    @ApiModelProperty(value = "产业方向")
    private String cyfx;

    @ApiModelProperty(value = "项目详情")
    private String xmxq;

    @ApiModelProperty(value = "推荐科创资源")
    private List<String> tjkczy;

    @ApiModelProperty(value = "推荐人才")
    private List<String> tjrc;

}
