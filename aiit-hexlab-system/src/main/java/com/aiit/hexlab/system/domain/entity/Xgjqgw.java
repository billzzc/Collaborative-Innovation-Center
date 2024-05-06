package com.aiit.hexlab.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Xgjqgw {

    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 产业
     */
    private String cy;
    /**
     * 岗位名称
     */
    private String gwmc;
    /**
     * 岗位职责
     */
    private String gwzz;
    /**
     * 核心技术
     */
    private String hxjs;
    /**
     * 岗位缺口数量
     */
    private Integer gwqksl;

}
