package com.aiit.hexlab.system.domain.vo.response.company;

import com.aiit.hexlab.system.domain.vo.response.index.DtzbResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CompanyIndexResponse {

    @ApiModelProperty(value = "产业重点企业")
    private Integer cyzdqy;

    @ApiModelProperty(value = "产业园区")
    private Integer cyyq;

    @ApiModelProperty(value = "产业集群创新平台")
    private Integer cyjqcxpt;

    @ApiModelProperty(value = "企业坐标列表")
    private List<DtzbResponse> maps;

}
