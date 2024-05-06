package com.aiit.hexlab.system.service;

import com.aiit.hexlab.system.domain.vo.response.company.*;
import com.aiit.hexlab.system.domain.vo.response.index.IndexResponse;
import com.aiit.hexlab.system.domain.vo.response.index.PieResponse;

import java.util.List;

public interface ICompanyService {

    CompanyIndexResponse index();

    List<PieResponse> qygl();

    ZdqyResponse zdqy();

    QyfnResponse qyfn();

    List<QyxqResponse> qyxq();

    XqhxResponse xqhx(String xqmc);

    void updateLatAndLgt();

}
