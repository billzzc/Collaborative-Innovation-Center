package com.aiit.hexlab.system.domain.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class DyrchxResponse {

    @ApiModelProperty(value = "姓名拼音")
    private String xmpy;

    @ApiModelProperty(value = "专利数")
    private String zls;

    @ApiModelProperty(value = "状态")
    private String zt;

    @ApiModelProperty(value = "学术职称")
    private String xszc;

    @ApiModelProperty(value = "创新创业")
    private String cxcy;

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

    @ApiModelProperty(value = "毕业院校")
    private String byyx;

    @ApiModelProperty(value = "工作单位")
    private String gzdw;

    @ApiModelProperty(value = "工作职级")
    private String gzzc;

    @ApiModelProperty(value = "匹配企业")
    private List<QyListHxResponse> qy;

    @ApiModelProperty(value = "匹配科创平台")
    private List<KcptResponse> kcpt;

    @ApiModelProperty(value = "匹配产业园区")
    private List<CyyqResponse> yq;

}
