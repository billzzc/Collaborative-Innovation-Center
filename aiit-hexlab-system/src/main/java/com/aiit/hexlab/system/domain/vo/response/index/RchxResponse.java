package com.aiit.hexlab.system.domain.vo.response.index;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class RchxResponse {

    @ApiModelProperty(value = "中文姓名")
    private String zwxm;

    @ApiModelProperty(value = "拼音姓名")
    private String pyxm;

    @ApiModelProperty(value = "人才类型")
    private String cxcy;

    @ApiModelProperty(value = "现在国家")
    private String xzgj;

    @ApiModelProperty(value = "专利数")
    private Integer zlsl;

    @ApiModelProperty(value = "学术职称")
    private String xszc;

    @ApiModelProperty(value = "工作职级")
    private String gzzj;

    @ApiModelProperty(value = "人才级别")
    private String rcjb;

    @ApiModelProperty(value = "代表成果")
    private String dbcg;

    @ApiModelProperty(value = "核心技术")
    private List<String> hxjs;

    @ApiModelProperty(value = "匹配企业")
    private List<String> ppqy;

}
