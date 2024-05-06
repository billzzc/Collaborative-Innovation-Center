package com.aiit.hexlab.system.domain.vo.response.index;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ZdxmResponse {

    @ApiModelProperty(value = "盯引项目")
    private Integer dyxm;

    @ApiModelProperty(value = "揭榜挂帅项目")
    private Integer jbgsxm;

    @ApiModelProperty(value = "科创项目")
    private Integer kcxm;

    @ApiModelProperty(value = "项目列表")
    private List<XmResponse> xmList;

}
