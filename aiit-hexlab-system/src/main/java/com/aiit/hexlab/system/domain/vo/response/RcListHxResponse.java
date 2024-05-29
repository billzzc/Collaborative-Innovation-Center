package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RcListHxResponse {

    private Long id;

    @ApiModelProperty(value = "姓名拼音")
    private String xmpy;

    @ApiModelProperty(value = "职称")
    private String zc;

    @ApiModelProperty(value = "研究领域")
    private String yjly;

    @ApiModelProperty(value = "代表成果")
    private String dbcg;

}
