package com.aiit.hexlab.system.service;

import com.aiit.hexlab.system.domain.vo.response.PieResponse;
import com.aiit.hexlab.system.domain.vo.response.RcfbResponse;

import java.util.List;

public interface IXtcxService {

    /**
     * 产业人才入库趋势
     * @return
     */
    List<RcfbResponse> cyrcrkqs();

    /**
     * 人才行业分布
     * @return
     */
    List<PieResponse> rchyfb();

    /**
     * 近3年企业服务态势2022-2024
     * @return
     */
    List<PieResponse> fwts();

    /**
     * 需求分析
     * @return
     */
    List<PieResponse> xqfx();

    /**
     * 创新成果分析
     * @return
     */
    List<PieResponse> cxcgfx();
}
