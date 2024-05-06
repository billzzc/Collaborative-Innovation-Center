package com.aiit.hexlab.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Cyyq {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String zyyq;

    private String lat;

    private String lgt;

}
