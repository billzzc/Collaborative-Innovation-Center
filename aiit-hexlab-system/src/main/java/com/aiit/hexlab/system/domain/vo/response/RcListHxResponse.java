package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RcListHxResponse {

    private Long id;

    @ApiModelProperty(value = "姓名拼音")
    private String xmpy;

    @ApiModelProperty(value = "学位")
    private String xw;

    @ApiModelProperty(value = "研究领域")
    private String yjly;

    @ApiModelProperty(value = "技术领域")
    private String jsly;

}
