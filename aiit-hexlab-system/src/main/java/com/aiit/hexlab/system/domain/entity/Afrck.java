package com.aiit.hexlab.system.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
public class Afrck {

    /**
     * id
     */
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
     * 年龄
     */
    private Integer nl;
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
     * 是否是生命健康领域人才
     */
    private String smjk;
    /**
     * 是否是智能物联领域人才
     */
    private String jcdl;
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
     * 批准通过时间
     */
    private String pztgsj;
    /**
     * 从事产业类别
     */
    private String cscylb;
    /**
     * 人才认定级别
     */
    private String rcrdjb;

    /**
     * 类别
     */
    private String lb;

}
