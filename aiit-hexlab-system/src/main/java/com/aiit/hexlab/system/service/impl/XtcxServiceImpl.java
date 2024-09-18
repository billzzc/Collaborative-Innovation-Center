package com.aiit.hexlab.system.service.impl;

import com.aiit.hexlab.system.domain.entity.*;
import com.aiit.hexlab.system.domain.vo.response.PieResponse;
import com.aiit.hexlab.system.domain.vo.response.RcfbResponse;
import com.aiit.hexlab.system.domain.vo.response.xtcxdp.*;
import com.aiit.hexlab.system.mapper.*;
import com.aiit.hexlab.system.service.IXtcxService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class XtcxServiceImpl implements IXtcxService {

    @Resource
    private LhsysMapper lhsysMapper;

    @Resource
    private GxgcsMapper gxgcsMapper;

    @Resource
    private HxjscyMapper hxjscyMapper;

    @Resource
    private CxcgfxMapper cxcgfxMapper;

    @Resource
    private XmMapper xmMapper;

    @Override
    public GcspystResponse gcspyst() {
        GcspystResponse response = new GcspystResponse();
        List<String> name = new ArrayList<>();
        name.add("北大信研院");
        name.add("浙大科创中心");
        name.add("浙大计创院");
        name.add("湘湖实验室");
        name.add("西电杭研所");
        name.add("湘湖高等研究院");
        name.add("巴顿研究院");
        response.setName(name);
        response.setYjyly(171);
        response.setDjzj(336);
        return response;
    }

    @Override
    public DkrcpyResponse dkrcpy() {
        DkrcpyResponse response = new DkrcpyResponse();
        response.setCyxrc(100);
        response.setZzjspx(22300);
        response.setDkgcs(1500);
        List<LhsysResponse> lhsysResponses = new ArrayList<>();
        List<Lhsys> lhsys = lhsysMapper.selectList(null);
        for (Lhsys lhsy : lhsys) {
            LhsysResponse lhsysResponse = new LhsysResponse();
            lhsysResponse.setId(lhsy.getId());
            lhsysResponse.setLhsysmc(lhsy.getLhsysmc());
            lhsysResponse.setHzqy(lhsy.getHzqy());
            lhsysResponse.setYtjg(lhsy.getYtjg());
            lhsysResponses.add(lhsysResponse);
        }
        response.setLhsys(lhsysResponses);
        return response;
    }

    @Override
    public GxgcsResponse gxgcs() {
        GxgcsResponse response = new GxgcsResponse();
        response.setZjgcs(1668);
        response.setGjgcs(1198);
        response.setZygcs(10);
        response.setQjgcs(20);
        response.setZkgcs(gxgcsMapper.selectCount(null));
        response.setPieResponses(gxgcsMapper.gxgcs());
        return response;
    }

    @Override
    public GcshxjsResponse gcshxjs() {
        GcshxjsResponse response = new GcshxjsResponse();
        List<GcsResponse> gcsResponses = new ArrayList<>();
        List<Gxgcs> gxgcs = gxgcsMapper.selectList(null);
        for (Gxgcs gxgcs1 : gxgcs) {
            GcsResponse gcsResponse = new GcsResponse();
            gcsResponse.setId(gxgcs1.getId());
            gcsResponse.setName(gxgcs1.getXm());
            gcsResponse.setRcjb(gxgcs1.getRcrdjb());
            gcsResponse.setXw(gxgcs1.getXw());
            gcsResponse.setZc(gxgcs1.getZc());
            gcsResponses.add(gcsResponse);
        }
        response.setGcs(gcsResponses);
        List<Hxjscy> hxjscyList = hxjscyMapper.selectList(null);
        List<PieResponse> cy = new ArrayList<>();
        for (Hxjscy hxjscy : hxjscyList) {
            PieResponse pieResponse = new PieResponse();
            pieResponse.setName(hxjscy.getName());
            pieResponse.setValue(hxjscy.getCount());
            cy.add(pieResponse);
        }
        response.setCy(cy);
        return response;
    }

    @Override
    public IndexResponse index() {
        IndexResponse response = new IndexResponse();
        response.setZjhjjjjxy(96734.427);
        response.setFwqy(2856);
        response.setLhsys(76);
        response.setFwljcs(6000);
        response.setFhqy(200);
        return response;
    }

    @Override
    public GcsfwfnResponse gcsfwfn() {
        GcsfwfnResponse response = new GcsfwfnResponse();
        response.setJbgs(16);
        response.setQyfwz(13);
        response.setJjqygexnt(434);
        response.setJjqyggongxnt(79);
        List<PieResponse> pieResponses = new ArrayList<>();
        PieResponse a = new PieResponse("人才需求", 235, 0.22);
        PieResponse b = new PieResponse("数字化改造", 424, 0.39);
        PieResponse c = new PieResponse("设备更新", 43, 0.04);
        PieResponse d = new PieResponse("企业提质", 95, 0.09);
        PieResponse e = new PieResponse("产学研合作", 193, 0.18);
        PieResponse f = new PieResponse("其他", 85, 0.08);
        pieResponses.add(a);
        pieResponses.add(b);
        pieResponses.add(c);
        pieResponses.add(d);
        pieResponses.add(e);
        pieResponses.add(f);
        response.setPieResponses(pieResponses);
        return response;
    }

    @Override
    public KccgResponse kccg() {
        KccgResponse response = new KccgResponse();
        response.setZlsq(1396);
        response.setCgzyzh(97);
        response.setPieResponses(cxcgfxMapper.cxcgfx());
        return response;
    }

    @Override
    public CxfhResponse cxfh() {
        CxfhResponse response = new CxfhResponse();
        response.setKyzdxm(42);
        response.setGnyzxm(16);
        response.setXm5213(88);
        List<XmResponse> xmResponses = new ArrayList<>();
        List<Xm> xms = xmMapper.selectList(null);
        for (Xm xm : xms) {
            XmResponse xmResponse = new XmResponse();
            xmResponse.setId(xm.getId());
            xmResponse.setXmmc(xm.getXmmc());
            xmResponse.setXmdw(xm.getYtdw());
            xmResponse.setXmlx(xm.getXmlx());
            xmResponses.add(xmResponse);
        }
        response.setXmResponses(xmResponses);
        return response;
    }
}
