package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CyxyrcResponse {

    private Long id;

    @ApiModelProperty(value = "姓名拼音")
    private String xmpy;

    @ApiModelProperty(value = "研究领域")
    private String yjly;

    @ApiModelProperty(value = "学术职称")
    private String xszc;

    @ApiModelProperty(value = "匹配公司")
    private String ppgs;

}
