package com.aiit.hexlab.system.domain.vo.response.xtcxdp;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class XmResponse {

    @ApiModelProperty(value = "序号")
    private Integer id;

    @ApiModelProperty(value = "项目名称")
    private String xmmc;

    @ApiModelProperty(value = "项目类型")
    private String xmlx;

    @ApiModelProperty(value = "项目单位")
    private String xmdw;

}
