package com.aiit.hexlab.system.mapper;

import com.aiit.hexlab.system.domain.entity.Xgjqgw;
import com.aiit.hexlab.system.domain.vo.response.index.CyrcxqResponse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface XgjqgwMapper extends BaseMapper<Xgjqgw> {

    List<CyrcxqResponse> groupByCy();

}
