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
     * 所属行业
     */
    private String cyfx;
    /**
     * 产品类别
     */
    private String cplb;
    /**
     * 核心技术
     */
    private String hxjs;
    /**
     * 领军技术人才
     */
    private String ljjsrc;
    /**
     * 企业类型
     */
    private String qylx;
    /**
     * 其他
     */
    private String qt;

    private String zdhy;

    private String xfsd;

    private String lat;

    private String lgt;

    private String cyly;

}
