package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DyrchxResponse {

    @ApiModelProperty(value = "姓名拼音")
    private String xmpy;

    @ApiModelProperty(value = "专利数")
    private String zls;

    @ApiModelProperty(value = "学术职称")
    private String xszc;

    @ApiModelProperty(value = "人才级别")
    private String rcjb;

    @ApiModelProperty(value = "现在国家")
    private String xzgj;

    @ApiModelProperty(value = "专业领域")
    private String zyly;

    @ApiModelProperty(value = "代表成果")
    private String dbcg;

    @ApiModelProperty(value = "核心技术")
    private String hxjs;

}
