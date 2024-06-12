package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CyxyrcResponse {

    private Long id;

    @ApiModelProperty(value = "姓名")
    private String xm;

    @ApiModelProperty(value = "专业领域")
    private String zyly;

    @ApiModelProperty(value = "学位")
    private String xw;

    @ApiModelProperty(value = "人才等级")
    private String rcdj;

    @ApiModelProperty(value = "专业")
    private String zy;

    @ApiModelProperty(value = "工作单位")
    private String gzdw;

    @ApiModelProperty(value = "工作单位id")
    private Long gzdwId;

    @ApiModelProperty(value = "人才状态")
    private String rczt;

}
