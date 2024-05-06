package com.aiit.hexlab.system.service;

import com.aiit.hexlab.system.domain.vo.response.index.IndexResponse;
import com.aiit.hexlab.system.domain.vo.response.talents.*;

import java.util.List;

public interface ITalentsService {

    IndexResponse index();

    List<QyResponse> cylgl(String type);

    List<KcptResponse> kcpt();

    List<JsgjcResponse> jsgjc(String type);

    List<CyxqqsfxResponse> cyxqqsfx();

    List<RdgwycResponse> rdgwyc();

    GwhxResponse gwhx(String gwmc);

}
