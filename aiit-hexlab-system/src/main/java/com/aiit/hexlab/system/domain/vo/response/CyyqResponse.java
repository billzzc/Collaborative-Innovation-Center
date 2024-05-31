package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CyyqResponse {

    private Long id;

    @ApiModelProperty(value = "园区名称")
    private String yqmc;

    @ApiModelProperty(value = "产业方向")
    private String cyfx;

    @ApiModelProperty(value = "主业定位")
    private String zydw;

}
