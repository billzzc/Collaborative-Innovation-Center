package com.aiit.hexlab.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Cyyq {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String yqmc;

    private String lat;

    private String lgt;

    private String tdxz;

    private String zdqy;

    private String cyly;

    private String cyfx;

    private String zdfx;

    private String xfsd;

    private String zydw;

    private String dz;

}
