package com.aiit.hexlab.system.service;

import com.aiit.hexlab.system.domain.vo.response.index.*;

import java.util.List;

public interface IIndexService {

    /**
     * 产业人才需求
     * @return
     */
    List<CyrcxqResponse> cyrcxq();

    /**
     * 产业急缺岗位
     * @return
     */
    List<CyjqgwResponse> cyjqgw();

    /**
     * 重大项目表
     */
    ZdxmResponse zdxm();

    IndexResponse index();

    List<QqhrzdrcResponse> qqhrzdrc();

    BdcyrcfxResponse bdcyrcfx();

    List<XflyrcfxResponse> xflyrcfx();

    RchxResponse rchx(String rcxm);

    XmhxResponse xmhx(String xmmc);

    QyhxResponse qyhx(String qymc);

    KcptResponse kcpt(String kcpt);
}
