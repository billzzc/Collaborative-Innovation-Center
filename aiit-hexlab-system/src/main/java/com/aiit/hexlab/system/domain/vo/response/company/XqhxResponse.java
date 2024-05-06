package com.aiit.hexlab.system.domain.vo.response.company;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class XqhxResponse {

    @ApiModelProperty(value = "需求名称")
    private String xqmc;

    @ApiModelProperty(value = "需求类型")
    private String xqlx;

    @ApiModelProperty(value = "需求详情")
    private String xqxq;

    @ApiModelProperty(value = "推荐科创资源")
    private List<String> tjkczy;

    @ApiModelProperty(value = "推荐人才")
    private List<String> tjrc;

}
