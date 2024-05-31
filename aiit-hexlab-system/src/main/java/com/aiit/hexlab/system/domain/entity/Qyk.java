package com.aiit.hexlab.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Qyk {

    /**
     * 序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 企业名称
     */
    private String qymc;
    /**
     * 产业方向
     */
    private String cyfx;
    /**
     * 主营产品
     */
    private String zycp;
    /**
     * 核心技术
     */
    private String hxjs;
    /**
     * 存量技术人才
     */
    private String cljsrc;
    /**
     * 荣誉梯度
     */
    private String rytd;
    /**
     * 其他
     */
    private String qt;
    /**
     * 纬度
     */
    private String lat;
    /**
     * 经度
     */
    private String lgt;
    /**
     * 重点方向
     */
    private String zdfx;
    /**
     * 细分赛道
     */
    private String xfsd;
    /**
     * 技术重点企业
     */
    private String jszdqy;
    /**
     * 地址
     */
    private String dz;
    /**
     * 产业领域
     */
    private String cyly;
    /**
     * 专精特新
     */
    private String zjtx;
}
