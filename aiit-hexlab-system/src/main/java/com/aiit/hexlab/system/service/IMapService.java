package com.aiit.hexlab.system.service;

import com.aiit.hexlab.system.domain.vo.response.*;

import java.util.List;

public interface IMapService {

    List<PieResponse> cyqygl(String type);

    CyhxjsResponse cyhxjs(String type, String name);

    CyqyResponse cyqy(String type);

    MapResponse index(String type);

    List<CyxyrcResponse> cyxyrc(String type);

    CydyrcResponse cydyrc(String type);

    List<CyyqResponse> cyyq(String type);

    List<KcptResponse> kcpt(String type);

    DyrchxResponse rchx(Long id);

    QyhxResponse qyhx(Long id);

    ZkrchxResponse rckrchx(Long id);

    CyyqhxResponse cyyqhx(Long id);

    KcpthxResponse kcpthx(Long id);

}
