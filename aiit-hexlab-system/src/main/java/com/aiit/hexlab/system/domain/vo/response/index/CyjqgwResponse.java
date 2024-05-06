package com.aiit.hexlab.system.domain.vo.response.index;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CyjqgwResponse {

    @ApiModelProperty(value = "产业")
    private String cy;

    @ApiModelProperty(value = "岗位")
    private String gw;

}
