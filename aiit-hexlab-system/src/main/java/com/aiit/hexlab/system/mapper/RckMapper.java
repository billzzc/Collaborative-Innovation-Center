package com.aiit.hexlab.system.mapper;

import com.aiit.hexlab.system.domain.entity.Rck;
import com.aiit.hexlab.system.domain.vo.response.index.DtzbResponse;
import com.aiit.hexlab.system.domain.vo.response.index.PieResponse;
import com.aiit.hexlab.system.domain.vo.response.index.QqhrzdrcResponse;
import com.aiit.hexlab.system.domain.vo.response.index.XflyrcfxResponse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface RckMapper extends BaseMapper<Rck> {

    List<DtzbResponse> select4maps();

    List<QqhrzdrcResponse> select4Qqhrzdrc();

    List<PieResponse> select4AgePie();

    List<XflyrcfxResponse> select4Xflyrcfx();
}
