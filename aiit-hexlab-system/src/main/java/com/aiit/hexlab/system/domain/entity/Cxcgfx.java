package com.aiit.hexlab.system.domain.entity;

import lombok.Data;

@Data
public class Cxcgfx {

    /**
     *
     */
    private Integer id;
    /**
     * 公开号
     */
    private String gkh;
    /**
     * 标题
     */
    private String bt;
    /**
     * 摘要
     */
    private String zy;
    /**
     * 当前申请人
     */
    private String dqsqr;
    /**
     * 申请日
     */
    private String sqr;
    /**
     * 发明人
     */
    private String fmr;
    /**
     * 简单法律状态
     */
    private String jdflzt;
    /**
     * 专利类型
     */
    private String zllx;

}
