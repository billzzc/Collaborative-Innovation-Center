package com.aiit.hexlab.system.domain.vo.response.company;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QyxqResponse {

    @ApiModelProperty(value = "需求名称")
    private String xqmc;

    @ApiModelProperty(value = "需求类型")
    private String xqlx;

    @ApiModelProperty(value = "企业/机构名称")
    private String jgmc;

}
