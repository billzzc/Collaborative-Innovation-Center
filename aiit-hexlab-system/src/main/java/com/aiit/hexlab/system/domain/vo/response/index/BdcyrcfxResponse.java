package com.aiit.hexlab.system.domain.vo.response.index;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class BdcyrcfxResponse {

    @ApiModelProperty(value = "创新人才")
    private Integer cxrc;

    @ApiModelProperty(value = "创业人才")
    private Integer cyrc;

    @ApiModelProperty(value = "年龄分布图")
    private List<PieResponse> agePie;

    @ApiModelProperty(value = "类型分布图")
    private List<PieResponse> typePie;

}
