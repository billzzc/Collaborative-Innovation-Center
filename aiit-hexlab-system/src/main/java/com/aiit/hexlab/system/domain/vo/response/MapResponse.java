package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MapResponse {

    private String value1;

    private String value2;

    private String value3;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "类型, 0是产业企业，1是产业园区，2是科创平台")
    private String type;

    private String lgt;

    private String lat;

}
