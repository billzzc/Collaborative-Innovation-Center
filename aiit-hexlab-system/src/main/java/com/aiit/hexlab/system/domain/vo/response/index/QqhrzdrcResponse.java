package com.aiit.hexlab.system.domain.vo.response.index;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QqhrzdrcResponse {

    @ApiModelProperty(value = "姓名拼音")
    private String xmpy;

    @ApiModelProperty(value = "研究领域")
    private String yjly;

    @ApiModelProperty(value = "代表成果")
    private String dbcg;

    @ApiModelProperty(value = "匹配公司")
    private String ppgs;

}
