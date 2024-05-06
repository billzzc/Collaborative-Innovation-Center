package com.aiit.hexlab.system.domain.vo.response.company;

import com.aiit.hexlab.system.domain.vo.response.talents.QyResponse;
import lombok.Data;

import java.util.List;

@Data
public class ZdqyResponse {

    private Integer gjgxjsqy;

    private Integer zjtxqy;

    private Integer xjrqy;

    private Integer gjkjxzxqy;

    private Integer dlqy;

    private List<QyResponse> qylb;

}
