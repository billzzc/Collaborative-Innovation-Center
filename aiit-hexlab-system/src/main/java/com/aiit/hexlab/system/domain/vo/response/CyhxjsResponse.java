package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CyhxjsResponse {

    @ApiModelProperty(name = "上面几排")
    private List<List<String>> title;

    @ApiModelProperty(name = "关键词")
    private List<PieResponse> gjc;

}
