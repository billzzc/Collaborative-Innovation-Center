package com.aiit.hexlab.system.domain.vo.response.xtcxdp;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GcsResponse {

    @ApiModelProperty(value = "序号")
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "职称")
    private String zc;

    @ApiModelProperty(value = "人才级别")
    private String rcjb;

    @ApiModelProperty(value = "学位")
    private String xw;

}
