package com.aiit.hexlab.system.domain.vo.response.xtcxdp;

import com.aiit.hexlab.system.domain.vo.response.PieResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KccgResponse {

    @ApiModelProperty(value = "专利申请")
    private Integer zlsq;

    @ApiModelProperty(value = "成果转移转化")
    private Integer cgzyzh;

    @ApiModelProperty(value = "专利申请分析")
    private List<PieResponse> pieResponses;

}
