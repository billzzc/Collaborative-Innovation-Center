package com.aiit.hexlab.system.domain.vo.response.company;

import com.aiit.hexlab.system.domain.vo.response.CoordinateResponse;
import com.aiit.hexlab.system.domain.vo.response.index.XflyrcfxResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class QyfnResponse {

    @ApiModelProperty(value = "解决企业个性难题")
    private Integer gexnt;

    @ApiModelProperty(value = "解决企业共性难题")
    private Integer gongxnt;

    @ApiModelProperty("企业赋能按月坐标数据")
    private List<CoordinateResponse> qyfnzb;


}
