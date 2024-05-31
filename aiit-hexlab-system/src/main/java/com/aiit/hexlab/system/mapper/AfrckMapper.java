package com.aiit.hexlab.system.mapper;

import com.aiit.hexlab.system.domain.entity.Afrck;
import com.aiit.hexlab.system.domain.vo.response.PieResponse;
import com.aiit.hexlab.system.domain.vo.response.RcfbResponse;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface AfrckMapper extends BaseMapper<Afrck> {
    @Select("select distinct gzdw from afrck")
    List<String> selectQy();

    @Select("SELECT " +
            "    CASE " +
            "        WHEN nl BETWEEN 21 AND 30 THEN '21-30' " +
            "        WHEN nl BETWEEN 31 AND 40 THEN '31-40' " +
            "        WHEN nl BETWEEN 41 AND 50 THEN '41-50' " +
            "        WHEN nl BETWEEN 51 AND 60 THEN '51-60' " +
            "        WHEN nl > 60 THEN '>60' " +
            "        ELSE '其他' " +
            "    END AS name, " +
            "    COUNT(*) AS value " +
            "FROM afrck " +
            "WHERE lb LIKE CONCAT('%', #{type}, '%') " +
            "GROUP BY name;")
    List<PieResponse> selectNlfb(@Param("type") String type);

    @Select("SELECT " +
            "    pztgsj AS nf, " +
            "    SUM(CASE WHEN rcrdjb = 'a' THEN 1 ELSE 0 END) AS a, " +
            "    SUM(CASE WHEN rcrdjb = 'b' THEN 1 ELSE 0 END) AS b, " +
            "    SUM(CASE WHEN rcrdjb = 'c' THEN 1 ELSE 0 END) AS c, " +
            "    SUM(CASE WHEN rcrdjb = 'd' THEN 1 ELSE 0 END) AS d, " +
            "    SUM(CASE WHEN rcrdjb = 'e' THEN 1 ELSE 0 END) AS e, " +
            "    SUM(CASE WHEN rcrdjb = 'f' THEN 1 ELSE 0 END) AS f " +
            "FROM afrck " +
            "where lb LIKE CONCAT('%', #{type}, '%') " +
            "GROUP BY pztgsj " +
            "ORDER BY pztgsj;")
    List<RcfbResponse> selectRcfb(@Param("type") String type);

    @Select("select xw as name, count(*) as value " +
            "from afrck " +
            "where lb LIKE CONCAT('%', #{type}, '%') " +
            "GROUP BY xw")
    List<PieResponse> selectXwfb(@Param("type") String type);
}
