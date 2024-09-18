package com.aiit.hexlab.system.domain.vo.response.xtcxdp;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GcspystResponse {

    private List<String> name;

    @ApiModelProperty(value = "研究领域")
    private Integer yjyly;

    @ApiModelProperty(value = "带教专家")
    private Integer djzj;

}
