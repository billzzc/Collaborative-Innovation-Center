package com.aiit.hexlab.system.service.impl;

import com.aiit.hexlab.system.domain.entity.*;
import com.aiit.hexlab.system.domain.vo.response.index.DtzbResponse;
import com.aiit.hexlab.system.domain.vo.response.index.IndexResponse;
import com.aiit.hexlab.system.domain.vo.response.talents.*;
import com.aiit.hexlab.system.mapper.*;
import com.aiit.hexlab.system.service.ITalentsService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class TalentsServiceImpl implements ITalentsService {

    @Resource
    private CyjqcxptMapper cyjqcxptMapper;

    @Resource
    private RckMapper rckMapper;

    @Resource
    private XgjqgwMapper xgjqgwMapper;

    @Resource
    private XmkMapper xmkMapper;

    @Resource
    private XqkMapper xkmMapper;

    @Resource
    private QykMapper qykMapper;

    @Override
    public IndexResponse index() {
        IndexResponse indexResponse = new IndexResponse();
        indexResponse.setZdxmsl(xmkMapper.selectCount(null));
        indexResponse.setZdrcrkl(rckMapper.selectCount(null));
        indexResponse.setCyrcxql(31.4);
        List<Xmk> xmks = xmkMapper.selectList(null);
        List<DtzbResponse> maps = new ArrayList<>();
        for (Xmk xmk : xmks) {
            DtzbResponse dtzbResponse = new DtzbResponse();
            dtzbResponse.setMc(xmk.getZj());
            dtzbResponse.setLgt(xmk.getLgt());
            dtzbResponse.setLat(xmk.getLat());
            dtzbResponse.setZyly(xmk.getCyly());
            dtzbResponse.setHxjs(xmk.getXfsd());
            dtzbResponse.setType(xmk.getXmmc());
            maps.add(dtzbResponse);
        }
        indexResponse.setMaps(maps);
        return indexResponse;
    }

    @Override
    public List<QyResponse> cylgl(String type) {
        List<QyResponse> responses = new ArrayList<>();
        List<Qyk> qyks = qykMapper.selectList(new LambdaQueryWrapper<Qyk>().eq(Qyk::getXfsd, type));
        for (Qyk qyk : qyks) {
            QyResponse response = new QyResponse();
            response.setCplb(qyk.getCplb());
            response.setQymc(qyk.getQymc());
            response.setQylX(qyk.getQylx());
            responses.add(response);
        }
        return responses;
    }

    @Override
    public List<KcptResponse> kcpt() {
        List<KcptResponse> responses = new ArrayList<>();
        List<Cyjqcxpt> cyjqcxpts = cyjqcxptMapper.selectList(null);
        for (Cyjqcxpt cyjqcxpt : cyjqcxpts) {
            KcptResponse response = new KcptResponse();
            response.setPtlx(cyjqcxpt.getLx());
            response.setPtmc(cyjqcxpt.getPtmc());
            response.setCyly(cyjqcxpt.getLy());
            responses.add(response);
        }
        return responses;
    }

    @Override
    public List<JsgjcResponse> jsgjc(String type) {
        List<JsgjcResponse> responses = new ArrayList<>();
        JsgjcResponse a = new JsgjcResponse();
        JsgjcResponse b = new JsgjcResponse();
        JsgjcResponse c = new JsgjcResponse();
        JsgjcResponse d = new JsgjcResponse();
        JsgjcResponse e = new JsgjcResponse();
        JsgjcResponse f = new JsgjcResponse();
        if (type.equals("合成生物")) {
            a.setMc("全基因");
            a.setSl(100);
            b.setMc("造纸化学品");
            b.setSl(200);
            c.setMc("乙酰苯胺");
            c.setSl(300);
            d.setMc("重组蛋白");
            d.setSl(400);
            e.setMc("蛋白分离材料");
            e.setSl(500);
            f.setMc("化学品");
            f.setSl(600);
        }
        if (type.equals("高端医疗器械")){
            a.setMc("工业3d");
            a.setSl(100);
            b.setMc("数智健康大平台");
            b.setSl(200);
            c.setMc("医用口罩");
            c.setSl(300);
            d.setMc("医疗器械");
            d.setSl(400);
            e.setMc("精准筛查");
            e.setSl(500);
            f.setMc("分子诊断");
            f.setSl(600);
        }
        if (type.equals("创新药")){
            a.setMc("生物制品");
            a.setSl(100);
            b.setMc("小分子抑制剂");
            b.setSl(200);
            c.setMc("原料药");
            c.setSl(300);
            d.setMc("核酸药物");
            d.setSl(400);
            e.setMc("细胞药物");
            e.setSl(500);
            f.setMc("干细胞技术");
            f.setSl(600);
        }
        if (type.equals("数字健康")){
            a.setMc("互联网+");
            a.setSl(100);
            b.setMc("智慧医疗");
            b.setSl(200);
            c.setMc("生物信息");
            c.setSl(300);
            d.setMc("云服务");
            d.setSl(400);
            e.setMc("诊断系统");
            e.setSl(500);
            f.setMc("人工智能");
            f.setSl(600);
        }
        responses.add(a);
        responses.add(b);
        responses.add(c);
        responses.add(d);
        responses.add(e);
        responses.add(f);
        return responses;
    }

    @Override
    public List<CyxqqsfxResponse> cyxqqsfx() {
        Random random = new Random();
        List<CyxqqsfxResponse> responses = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            CyxqqsfxResponse response = new CyxqqsfxResponse();
            response.setX(i + "月");
            response.setY(random.nextInt(18) + 3);
            responses.add(response);
        }
        return responses;
    }

    @Override
    public List<RdgwycResponse> rdgwyc() {
        List<RdgwycResponse> responses = new ArrayList<>();
        List<Xgjqgw> xgjqgws = xgjqgwMapper.selectList(null);
        for (Xgjqgw xgjqgw : xgjqgws) {
            RdgwycResponse response = new RdgwycResponse();
            response.setCy(xgjqgw.getCy());
            response.setGwmc(xgjqgw.getGwmc());
            responses.add(response);
        }
        return responses;
    }

    @Override
    public GwhxResponse gwhx(String gwmc) {
        GwhxResponse response = new GwhxResponse();
        Xgjqgw xgjqgw = xgjqgwMapper.selectOne(new LambdaQueryWrapper<Xgjqgw>().eq(Xgjqgw::getGwmc, gwmc.trim()));
        if (xgjqgw != null) {
            response.setGwxq(xgjqgw.getGwzz());
            response.setGwmc(xgjqgw.getGwmc());
            response.setCyly(xgjqgw.getCy());
            response.setHxjs(xgjqgw.getHxjs());
            if (xgjqgw.getCy().equals("生命健康")) {
                List<Rck> rcks = rckMapper.selectList(null);
                Collections.shuffle(rcks);
                List<String> tjrc = new ArrayList<>();
                for (Rck rck : rcks.subList(0,3)) {
                    tjrc.add(rck.getPyxm().trim());
                }
                response.setTjrc(tjrc);
            }
        }
        return response;
    }
}
