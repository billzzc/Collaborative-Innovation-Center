package com.aiit.hexlab.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Cyjqcxpt {

    /**
     * 序号
     */
    @TableId(value = "xh", type = IdType.AUTO)
    private Long xh;
    /**
     * 类型
     */
    private String lx;
    /**
     * 领域
     */
    private String ly;
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

    private String zdhy;

    private String xfsd;
}
