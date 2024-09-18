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
public class GxgcsResponse {

    @ApiModelProperty(value = "在库工程师")
    private Integer zkgcs;

    private List<PieResponse> pieResponses;

    @ApiModelProperty(value = "中级工程师")
    private Integer zjgcs;

    @ApiModelProperty(value = "高级工程师")
    private Integer gjgcs;

    @ApiModelProperty(value = "青俊工程师")
    private Integer qjgcs;

    @ApiModelProperty(value = "卓越工程师")
    private Integer zygcs;

}
