package com.aiit.hexlab.system.mapper;

import com.aiit.hexlab.system.domain.entity.Qyk;
import com.aiit.hexlab.system.domain.vo.response.index.PieResponse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface QykMapper extends BaseMapper<Qyk> {

    List<PieResponse> qygl();

}
