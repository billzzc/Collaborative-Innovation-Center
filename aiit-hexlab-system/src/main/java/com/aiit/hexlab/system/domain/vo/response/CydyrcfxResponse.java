package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CydyrcfxResponse {

    @ApiModelProperty(value = "年龄分布")
    private List<PieResponse> nlfb;

    @ApiModelProperty(value = "人才级别")
    private List<PieResponse> rcjb;

}
