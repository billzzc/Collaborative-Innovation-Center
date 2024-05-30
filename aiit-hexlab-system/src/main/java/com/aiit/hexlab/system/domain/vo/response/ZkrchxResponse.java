package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class ZkrchxResponse {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "人才级别")
    private String rcjb;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "学位")
    private String xw;

    @ApiModelProperty(value = "国籍")
    private String gj;

    @ApiModelProperty(value = "政治面貌")
    private String zzmm;

    @ApiModelProperty(value = "毕业院校")
    private String byyx;

    @ApiModelProperty(value = "专业领域")
    private String zyly;

    @ApiModelProperty(value = "行政职务")
    private String xzzw;

    @ApiModelProperty(value = "技术职称")
    private String jszc;

    @ApiModelProperty(value = "核心技术")
    private String hxjs;

    @ApiModelProperty(value = "企业列表")
    private List<QyListHxResponse> qy;

}
