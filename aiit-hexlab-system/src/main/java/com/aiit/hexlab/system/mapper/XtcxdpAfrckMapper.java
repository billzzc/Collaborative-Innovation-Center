package com.aiit.hexlab.system.mapper;

import com.aiit.hexlab.system.domain.entity.XtcxdpAfrck;
import com.aiit.hexlab.system.domain.vo.response.RcfbResponse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface XtcxdpAfrckMapper extends BaseMapper<XtcxdpAfrck> {

    @Select("SELECT " +
            "    pztgsj AS nf, " +
            "    SUM(CASE WHEN rcrdjb = 'a' THEN 1 ELSE 0 END) AS a, " +
            "    SUM(CASE WHEN rcrdjb = 'b' THEN 1 ELSE 0 END) AS b, " +
            "    SUM(CASE WHEN rcrdjb = 'c' THEN 1 ELSE 0 END) AS c, " +
            "    SUM(CASE WHEN rcrdjb = 'd' THEN 1 ELSE 0 END) AS d, " +
            "    SUM(CASE WHEN rcrdjb = 'e' THEN 1 ELSE 0 END) AS e, " +
            "    SUM(CASE WHEN rcrdjb = 'f' THEN 1 ELSE 0 END) AS f " +
            "FROM xtcxdp_afrck " +
            "GROUP BY pztgsj " +
            "ORDER BY pztgsj;")
    List<RcfbResponse> selectCyrcrkqs();

}
