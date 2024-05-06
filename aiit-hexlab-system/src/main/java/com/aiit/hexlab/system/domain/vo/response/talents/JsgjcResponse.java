package com.aiit.hexlab.system.domain.vo.response.talents;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class JsgjcResponse {

    @ApiModelProperty(value = "名称")
    private String mc;

    @ApiModelProperty(value = "数量")
    private Integer sl;

}
