package com.aiit.hexlab.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("xtcxdp_afrck")
public class XtcxdpAfrck {

    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 姓名
     */
    private String xm;
    /**
     * 性别
     */
    private String sex;
    /**
     * 国籍
     */
    private String gj;
    /**
     * 出生年月
     */
    private String csny;
    /**
     * 民族
     */
    private String mz;
    /**
     * 出生地
     */
    private String csd;
    /**
     * 政治面貌
     */
    private String zzmm;
    /**
     * 行政职务
     */
    private String xzzw;
    /**
     * 工作单位
     */
    private String gzdw;
    /**
     * 单位矫正
     */
    private String dwjz;
    /**
     * 是否在生命健康
     */
    private String smjk;
    /**
     * 是否在智能物联
     */
    private String znwl;
    /**
     * 是否在纤维新材料
     */
    private String xwxcl;
    /**
     * 是否在智能汽车
     */
    private String znqc;
    /**
     * 是否在高端装备
     */
    private String gdzb;
    /**
     * 单位类别
     */
    private String dwlb;
    /**
     * 人才认定级别
     */
    private String rcrdjb;
    /**
     * 学历
     */
    private String xl;
    /**
     * 学位
     */
    private String xw;
    /**
     * 专业
     */
    private String zy;
    /**
     * 毕业院校
     */
    private String byyx;
    /**
     * 职称
     */
    private String zc;
    /**
     * 资格技术
     */
    private String zgjs;
    /**
     * 资格技能
     */
    private String zgjn;
    /**
     * 审核部门
     */
    private String shbm;
    /**
     * 批准通过时间
     */
    private String pztgsj;
    /**
     * 从事产业类别
     */
    private String cscylb;
    /**
     * 年龄
     */
    private Integer nl;

}
