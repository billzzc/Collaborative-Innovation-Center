package com.aiit.hexlab.system.domain.vo.response.index;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class IndexResponse {

    @ApiModelProperty(value = "重点人才入库量")
    private Integer zdrcrkl;

    @ApiModelProperty(value = "重点项目数量")
    private Integer zdxmsl;

    @ApiModelProperty(value = "产业人才需求量")
    private Double cyrcxql;

    @ApiModelProperty(value = "中央地图人才来源")
    private List<DtzbResponse> maps;

}
