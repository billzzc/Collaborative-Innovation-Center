package com.aiit.hexlab.system.domain.vo.response.xtcxdp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CxfhResponse {

    private Integer kyzdxm;

    private Integer gnyzxm;

    private Integer xm5213;

    private List<XmResponse> xmResponses;

}
