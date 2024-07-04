package com.aiit.hexlab.system.service.impl;

import com.aiit.hexlab.system.domain.entity.XtcxdpAfrck;
import com.aiit.hexlab.system.domain.vo.response.PieResponse;
import com.aiit.hexlab.system.domain.vo.response.RcfbResponse;
import com.aiit.hexlab.system.mapper.XtcxdpAfrckMapper;
import com.aiit.hexlab.system.service.IXtcxService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class XtcxServiceImpl implements IXtcxService {

    @Resource
    private XtcxdpAfrckMapper xtcxdpAfrckMapper;

    @Override
    public List<RcfbResponse> cyrcrkqs() {
        return xtcxdpAfrckMapper.selectCyrcrkqs();
    }

    @Override
    public List<PieResponse> rchyfb() {
        List<PieResponse> result = new ArrayList<>();
        Integer smjk = xtcxdpAfrckMapper.selectCount(new LambdaQueryWrapper<XtcxdpAfrck>().eq(XtcxdpAfrck::getSmjk, "1"));
        Integer znwl = xtcxdpAfrckMapper.selectCount(new LambdaQueryWrapper<XtcxdpAfrck>().eq(XtcxdpAfrck::getZnwl, "1"));
        Integer znqc = xtcxdpAfrckMapper.selectCount(new LambdaQueryWrapper<XtcxdpAfrck>().eq(XtcxdpAfrck::getZnqc, "1"));
        Integer xwxcl = xtcxdpAfrckMapper.selectCount(new LambdaQueryWrapper<XtcxdpAfrck>().eq(XtcxdpAfrck::getXwxcl, "1"));
        Integer gdzb = xtcxdpAfrckMapper.selectCount(new LambdaQueryWrapper<XtcxdpAfrck>().eq(XtcxdpAfrck::getGdzb, "1"));
        Integer qt = xtcxdpAfrckMapper.selectCount(new LambdaQueryWrapper<XtcxdpAfrck>().ne(XtcxdpAfrck::getSmjk, "1")
                .ne(XtcxdpAfrck::getZnwl, "1").ne(XtcxdpAfrck::getZnqc, "1").ne(XtcxdpAfrck::getXwxcl, "1").ne(XtcxdpAfrck::getGdzb, "1"));
        Integer amount = smjk + znwl + znqc + xwxcl + gdzb + qt;

        PieResponse a = new PieResponse("生命健康", smjk, smjk / (double) amount);
        PieResponse b = new PieResponse("智能物联", znwl, znwl / (double) amount);
        PieResponse c = new PieResponse("智能汽车", znqc, znqc / (double) amount);
        PieResponse d = new PieResponse("纤维新材料", xwxcl, xwxcl / (double) amount);
        PieResponse e = new PieResponse("高端装备", gdzb, gdzb / (double) amount);
        PieResponse f = new PieResponse("其他", qt, qt / (double) amount);
        result.add(a);
        result.add(b);
        result.add(c);
        result.add(d);
        result.add(e);
        result.add(f);
        return result;
    }

    @Override
    public List<PieResponse> fwts() {
        List<PieResponse> result = new ArrayList<>();
        PieResponse a = new PieResponse("2022 H1", 499);
        PieResponse b = new PieResponse("2022 H2", 525);
        PieResponse c = new PieResponse("2023 H1", 575);
        PieResponse d = new PieResponse("2023 H2", 624);
        PieResponse e = new PieResponse("2024 H1", 633);
        result.add(a);
        result.add(b);
        result.add(c);
        result.add(d);
        result.add(e);
        return result;
    }

    @Override
    public List<PieResponse> xqfx() {
        List<PieResponse> result = new ArrayList<>();
        PieResponse a = new PieResponse("人才需求", 235, 0.22);
        PieResponse b = new PieResponse("数字化改造", 424, 0.39);
        PieResponse c = new PieResponse("设备更新", 43, 0.04);
        PieResponse d = new PieResponse("企业提质", 95, 0.09);
        PieResponse e = new PieResponse("产学研合作", 193, 0.18);
        PieResponse f = new PieResponse("其他", 85, 0.08);
        result.add(a);
        result.add(b);
        result.add(c);
        result.add(d);
        result.add(e);
        result.add(f);
        return result;
    }

    @Override
    public List<PieResponse> cxcgfx() {
        List<PieResponse> result = new ArrayList<>();
        PieResponse a = new PieResponse("发明专利", 945, 0.6769);
        PieResponse b = new PieResponse("实用新型", 75, 0.05373);
        PieResponse c = new PieResponse("授权发明", 364, 0.2607);
        PieResponse d = new PieResponse("外观设计", 12, 0.0086);
        result.add(a);
        result.add(b);
        result.add(c);
        result.add(d);
        return result;
    }
}
