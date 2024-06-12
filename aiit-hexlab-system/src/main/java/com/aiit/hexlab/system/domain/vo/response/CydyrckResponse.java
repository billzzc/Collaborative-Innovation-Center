package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CydyrckResponse {

    @ApiModelProperty(value = "姓名拼音")
    private String xmpy;

    @ApiModelProperty(value = "研究领域")
    private String yjly;

    @ApiModelProperty(value = "学术职称")
    private String xszc;

    @ApiModelProperty(value = "所在国家")
    private String szgj;

    @ApiModelProperty(value = "匹配公司")
    private String ppgs;

    @ApiModelProperty(value = "匹配公司id")
    private Long ppgsId;

    @ApiModelProperty(value = "引进状态")
    private String yjzt;

}
