package com.aiit.hexlab.system.service;

import com.aiit.hexlab.system.domain.vo.response.PieResponse;
import com.aiit.hexlab.system.domain.vo.response.RcfbResponse;
import com.aiit.hexlab.system.domain.vo.response.xtcxdp.*;

import java.util.List;

public interface IXtcxService {

    GcspystResponse gcspyst();

    DkrcpyResponse dkrcpy();

    GxgcsResponse gxgcs();

    GcshxjsResponse gcshxjs();

    IndexResponse index();

    GcsfwfnResponse gcsfwfn();

    KccgResponse kccg();

    CxfhResponse cxfh();

}
