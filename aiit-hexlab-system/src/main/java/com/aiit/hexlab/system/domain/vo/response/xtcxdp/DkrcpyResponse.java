package com.aiit.hexlab.system.domain.vo.response.xtcxdp;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DkrcpyResponse {

    @ApiModelProperty(value = "创业型人才")
    private Integer cyxrc;

    @ApiModelProperty(value = "多跨工程师")
    private Integer dkgcs;

    @ApiModelProperty(value = "组织技术培训")
    private Integer zzjspx;

    @ApiModelProperty(value = "联合实验室")
    private List<LhsysResponse> lhsys;


}
