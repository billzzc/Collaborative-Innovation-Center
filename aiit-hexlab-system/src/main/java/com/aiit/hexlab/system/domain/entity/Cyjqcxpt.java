package com.aiit.hexlab.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Cyjqcxpt {

    /**
     * 序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 类型
     */
    private String lx;
    /**
     * 核心技术
     */
    private String hxjs;
    /**
     * 平台名称
     */
    private String ptmc;
    /**
     * 依托机构
     */
    private String ytjg;

    private String zdfx;

    private String xfsd;

    private String cyly;

    private String lgt;

    private String lat;

    private String cyfx;

    private String dz;
}
