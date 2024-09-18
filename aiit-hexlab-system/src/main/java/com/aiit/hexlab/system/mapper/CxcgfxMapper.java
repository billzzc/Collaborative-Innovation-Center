package com.aiit.hexlab.system.mapper;

import com.aiit.hexlab.system.domain.entity.Cxcgfx;
import com.aiit.hexlab.system.domain.vo.response.PieResponse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CxcgfxMapper extends BaseMapper<Cxcgfx> {

    @Select("select zllx as name,  count(*) as value, count(*)/(select count(*) from cxcgfx) as percent  from cxcgfx GROUP BY zllx")
    List<PieResponse> cxcgfx();

}
