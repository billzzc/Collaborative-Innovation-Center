package com.aiit.hexlab.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Xmk {

    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 编号
     */
    private String bh;
    /**
     * 项目状态
     */
    private String xmzt;
    /**
     * 产业领域
     */
    private String cyly;
    /**
     * 产业方向
     */
    private String cyfx;
    /**
     * 重点行业
     */
    private String zdhy;
    /**
     * 细分赛道
     */
    private String xfsd;
    /**
     * 项目名称
     */
    private String xmmc;
    /**
     * 项目类型
     */
    private String xmlx;
    /**
     * 项目详情
     */
    private String xmxq;
    /**
     * 相关核心技术
     */
    private String xghxsj;
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
     * 项目负责人姓名
     */
    private String xmfzrxm;
    /**
     * 联系人职务
     */
    private String lxrzw;
    /**
     * 联系方式
     */
    private String lxfs;
    /**
     * 项目金额
     */
    private String xmje;

    private String lgt;

    private String lat;

}
