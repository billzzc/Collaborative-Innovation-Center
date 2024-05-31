package com.aiit.hexlab.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Dyrc {

    /**
     *
     */
    private String nlfw;
    /**
     *
     */
    private String rcjb;
    /**
     *
     */
    private String cxcy;
    /**
     *
     */
    private String xmpy;
    /**
     *
     */
    private String xmzw;
    /**
     *
     */
    private String xszc;
    /**
     *
     */
    private String xzdgj;
    /**
     *
     */
    private String gzzj;
    /**
     *
     */
    private String xgzdw;
    /**
     *
     */
    private String zgxlbyyx;
    /**
     *
     */
    private String yjly;
    /**
     *
     */
    private String dbcg;
    /**
     *
     */
    private String zlsl;
    /**
     *
     */
    private String jslya;
    /**
     *
     */
    private String jslyb;
    /**
     *
     */
    private String jslyc;
    /**
     *
     */
    private String mail;
    /**
     *
     */
    private String ppqy;
    /**
     *
     */
    private String ppyq;
    /**
     *
     */
    private String ppcxpt;
    /**
     *
     */
    private String ppdyxm;
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String cyly;

}
