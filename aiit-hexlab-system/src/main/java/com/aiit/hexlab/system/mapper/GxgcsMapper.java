package com.aiit.hexlab.system.mapper;

import com.aiit.hexlab.system.domain.entity.Gxgcs;
import com.aiit.hexlab.system.domain.vo.response.PieResponse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GxgcsMapper extends BaseMapper<Gxgcs> {

    @Select("select xw as name,  count(*) as value, count(*)/(select count(*) from gxgcs) as percent  from gxgcs GROUP BY xw")
    List<PieResponse> gxgcs();

}
