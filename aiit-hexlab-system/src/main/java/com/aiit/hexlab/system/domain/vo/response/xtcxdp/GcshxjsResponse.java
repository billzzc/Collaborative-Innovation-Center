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
public class GcshxjsResponse {

    @ApiModelProperty(value = "词云")
    private List<PieResponse> cy;

    @ApiModelProperty(value = "工程师")
    private List<GcsResponse> gcs;

}
