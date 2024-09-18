package com.aiit.hexlab.system.domain.vo.response.xtcxdp;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexResponse {

    @ApiModelProperty(value = "直接或间接经济效益")
    private Double zjhjjjjxy;

    @ApiModelProperty(value = "服务企业")
    private Integer fwqy;

    @ApiModelProperty(value = "服务累计次数")
    private Integer fwljcs;

    @ApiModelProperty(value = "联合实验室")
    private Integer lhsys;

    @ApiModelProperty(value = "孵化企业")
    private Integer fhqy;
}
