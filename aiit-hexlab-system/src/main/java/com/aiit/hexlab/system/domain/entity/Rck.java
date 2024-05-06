package com.aiit.hexlab.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Rck {

    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * TR编号
     */
    private String trbh;
    /**
     * 年龄范围
     */
    private String nlfw;
    /**
     * 人才级别
     */
    private String rcjb;
    /**
     * 创新/创业
     */
    private String cxcy;
    /**
     * 拼音姓名
     */
    private String pyxm;
    /**
     * 中文姓名
     */
    private String zwxm;
    /**
     * 学术职称
     */
    private String xszc;
    /**
     * 现在国家
     */
    private String xzgj;
    /**
     * 工作职级
     */
    private String gzzj;
    /**
     * 现工作单位
     */
    private String xgzdw;
    /**
     * 最高学历毕业院校
     */
    private String zgxlbyyx;
    /**
     * 研究领域
     */
    private String yjly;
    /**
     * 代表成果
     */
    private String dbcg;
    /**
     * 专利数量
     */
    private Integer zlsl;
    /**
     * 技术领域A
     */
    private String jslya;
    /**
     * 技术领域B
     */
    private String jslyb;
    /**
     * 技术领域C
     */
    private String jslyc;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 匹配公司
     */
    private String ppgs;

}
