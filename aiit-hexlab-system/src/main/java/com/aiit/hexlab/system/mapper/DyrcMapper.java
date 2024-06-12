package com.aiit.hexlab.system.mapper;

import com.aiit.hexlab.system.domain.entity.Dyrc;
import com.aiit.hexlab.system.domain.vo.response.DyrclyResponse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DyrcMapper extends BaseMapper<Dyrc> {

    @Select("select d.xzdgj as gzmc, count(*) as number, c.lgt, c.lat from dyrc d left join country_location c on d.xzdgj = c.name_cn where d.cyly = #{type} group by d.xzdgj ORDER BY count(*) DESC LIMIT 5")
    List<DyrclyResponse> dyrcly(String type);
}
