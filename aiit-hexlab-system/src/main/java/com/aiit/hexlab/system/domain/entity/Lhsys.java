package com.aiit.hexlab.system.domain.entity;

import lombok.Data;

@Data
public class Lhsys {

    /**
     *
     */
    private Integer id;
    /**
     * 联合实验室名称
     */
    private String lhsysmc;
    /**
     * 依托机构
     */
    private String ytjg;
    /**
     * 合作企业
     */
    private String hzqy;
    /**
     * 联合实验室地址
     */
    private String lhsysdz;
    /**
     * 经度
     */
    private String lat;
    /**
     * 纬度
     */
    private String lgt;
    /**
     * 成立时间
     */
    private String clsj;

}
