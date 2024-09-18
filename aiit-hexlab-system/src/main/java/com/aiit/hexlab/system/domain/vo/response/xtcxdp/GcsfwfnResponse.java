package com.aiit.hexlab.system.domain.vo.response.xtcxdp;

import com.aiit.hexlab.system.domain.vo.response.PieResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GcsfwfnResponse {

    @ApiModelProperty(value = "区域服务站")
    private Integer qyfwz;

    @ApiModelProperty(value = "揭榜挂帅")
    private Integer jbgs;

    @ApiModelProperty(value = "解决企业个性难题")
    private Integer jjqygexnt;

    @ApiModelProperty(value = "解决企业共性难题")
    private Integer jjqyggongxnt;

    @ApiModelProperty(value = "需求分析")
    private List<PieResponse> pieResponses;

}
