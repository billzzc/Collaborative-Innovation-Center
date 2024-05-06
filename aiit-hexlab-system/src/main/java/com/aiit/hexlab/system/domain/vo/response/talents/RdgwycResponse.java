package com.aiit.hexlab.system.domain.vo.response.talents;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RdgwycResponse {

    @ApiModelProperty(value = "产业")
    private String cy;

    @ApiModelProperty(value = "岗位名称")
    private String gwmc;

}
