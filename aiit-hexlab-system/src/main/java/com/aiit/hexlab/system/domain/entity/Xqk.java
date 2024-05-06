package com.aiit.hexlab.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Xqk {

    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 产业领域
     */
    private String cyly;
    /**
     * 核心技术
     */
    private String hxjs;
    /**
     * 需求类型
     */
    private String xqlx;
    /**
     * 机构名称
     */
    private String jgmc;
    /**
     * 城市
     */
    private String cs;
    /**
     * 区域
     */
    private String qy;
    /**
     * 镇街
     */
    private String zj;
    /**
     * 需求描述
     */
    private String xqms;
    /**
     * 预算
     */
    private String ys;
    /**
     * 编号
     */
    private String bh;
    /**
     * 需求状态
     */
    private String xqzt;
    /**
     * 需求名称
     */
    private String xqmc;

}
