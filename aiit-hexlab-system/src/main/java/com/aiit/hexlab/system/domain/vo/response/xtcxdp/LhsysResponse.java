package com.aiit.hexlab.system.domain.vo.response.xtcxdp;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LhsysResponse {

    @ApiModelProperty(value = "序号")
    private Integer id;

    @ApiModelProperty(value = "联合实验室名称")
    private String lhsysmc;

    @ApiModelProperty(value = "依托机构")
    private String ytjg;

    @ApiModelProperty(value = "合作企业")
    private String hzqy;

}
