package com.aiit.hexlab.system.service;

import com.aiit.hexlab.system.domain.vo.response.*;

import java.util.List;

public interface IMapService {

    List<PieResponse> cyqygl(String type);

    CyhxjsResponse cyhxjs(String type, String name);

    CyqyResponse cyqy(String type);

    IndexResponse index(String type, String name);

    List<CyxyrcResponse> cyxyrc(String type);

    CydyrcResponse cyrck(String type);

    List<CyyqResponse> cyyq(String type);

    List<KcptResponse> kcpt(String type);

    DyrchxResponse rchx(Long id, String type);

    QyhxResponse qyhx(Long id);

    ZkrchxResponse rckrchx(Long id, String type);

    CyyqhxResponse cyyqhx(Long id);

    KcpthxResponse kcpthx(Long id);

    List<CydyrckResponse> cydyrck(String type);

    List<DyrclyResponse> dyrcly(String type);

    CydyrcfxResponse cydyrcfx(String type);

    void location(String type);

}
