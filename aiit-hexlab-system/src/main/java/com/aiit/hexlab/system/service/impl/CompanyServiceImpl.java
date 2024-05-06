package com.aiit.hexlab.system.service.impl;

import com.aiit.hexlab.common.utils.StringUtils;
import com.aiit.hexlab.system.LocationUtils;
import com.aiit.hexlab.system.domain.entity.*;
import com.aiit.hexlab.system.domain.vo.response.CoordinateResponse;
import com.aiit.hexlab.system.domain.vo.response.company.*;
import com.aiit.hexlab.system.domain.vo.response.index.DtzbResponse;
import com.aiit.hexlab.system.domain.vo.response.index.IndexResponse;
import com.aiit.hexlab.system.domain.vo.response.index.PieResponse;
import com.aiit.hexlab.system.domain.vo.response.talents.QyResponse;
import com.aiit.hexlab.system.mapper.*;
import com.aiit.hexlab.system.service.ICompanyService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Resource
    private CyjqcxptMapper cyjqcxptMapper;

    @Resource
    private RckMapper rckMapper;

    @Resource
    private XgjqgwMapper xgjqgwMapper;

    @Resource
    private XmkMapper xmkMapper;

    @Resource
    private XqkMapper xqkMapper;

    @Resource
    private QykMapper qykMapper;

    @Resource
    private CyyqMapper cyyqMapper;

    @Override
    public CompanyIndexResponse index() {
        CompanyIndexResponse companyIndexResponse = new CompanyIndexResponse();
        companyIndexResponse.setCyjqcxpt(cyjqcxptMapper.selectCount(null));
        companyIndexResponse.setCyzdqy(57);
        companyIndexResponse.setCyyq(14);

        // 产业园区数据
        List<Cyyq> cyyqs = cyyqMapper.selectList(null);

        // 重点企业数据
        List<Qyk> qyks = qykMapper.selectList(null);

        List<DtzbResponse> maps = new ArrayList<>();
        for (Cyyq cyyq : cyyqs) {
            DtzbResponse dtzbResponse = new DtzbResponse();
            dtzbResponse.setMc(cyyq.getZyyq());
            dtzbResponse.setLat(cyyq.getLat());
            dtzbResponse.setLgt(cyyq.getLgt());
            dtzbResponse.setType("产业园区");
            maps.add(dtzbResponse);
        }
        for (Qyk qyk : qyks) {
            DtzbResponse dtzbResponse = new DtzbResponse();
            dtzbResponse.setMc(qyk.getQymc());
            dtzbResponse.setLat(qyk.getLat());
            dtzbResponse.setLgt(qyk.getLgt());
            dtzbResponse.setType("重点企业");
            maps.add(dtzbResponse);
        }
        companyIndexResponse.setMaps(maps);
        return companyIndexResponse;
    }

    @Override
    public List<PieResponse> qygl() {
        return qykMapper.qygl();
    }

    @Override
    public ZdqyResponse zdqy() {
        ZdqyResponse zdqyResponse = new ZdqyResponse();
        zdqyResponse.setGjgxjsqy(qykMapper.selectCount(new LambdaQueryWrapper<Qyk>().like(Qyk::getQylx, "国家高新技术")));
        zdqyResponse.setZjtxqy(qykMapper.selectCount(new LambdaQueryWrapper<Qyk>().like(Qyk::getQylx, "专精特新")));
        zdqyResponse.setXjrqy(qykMapper.selectCount(new LambdaQueryWrapper<Qyk>().like(Qyk::getQylx, "小巨人")));
        zdqyResponse.setGjkjxzxqy(qykMapper.selectCount(new LambdaQueryWrapper<Qyk>().like(Qyk::getQylx, "国家科技型中小")));
        zdqyResponse.setDlqy(qykMapper.selectCount(new LambdaQueryWrapper<Qyk>().like(Qyk::getQylx, "瞪羚")));

        List<QyResponse> responses = new ArrayList<>();
        List<Qyk> qyks = qykMapper.selectList(null);
        qyks.forEach(qyk -> {
            QyResponse qyResponse = new QyResponse();
            qyResponse.setQymc(qyk.getQymc());
            qyResponse.setQylX(qyk.getQylx());
            qyResponse.setCplb(qyk.getCplb());
            responses.add(qyResponse);
        });
        zdqyResponse.setQylb(responses);
        return zdqyResponse;
    }

    @Override
    public QyfnResponse qyfn() {
        QyfnResponse qyfnResponse = new QyfnResponse();
        Random random = new Random();
        qyfnResponse.setGexnt(263);
        qyfnResponse.setGongxnt(132);
        List<CoordinateResponse> responses = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            CoordinateResponse response = new CoordinateResponse();
            response.setX(i + "月");
            response.setY(random.nextInt(18) + 3);
            responses.add(response);
        }
        qyfnResponse.setQyfnzb(responses);
        return qyfnResponse;
    }

    @Override
    public List<QyxqResponse> qyxq() {
        List<QyxqResponse> responses = new ArrayList<>();
        List<Xqk> xqks = xqkMapper.selectList(null);
        xqks.forEach(xqk -> {
            QyxqResponse response = new QyxqResponse();
            response.setXqmc(xqk.getXqmc());
            response.setXqlx(xqk.getXqlx());
            response.setJgmc(xqk.getJgmc());
            responses.add(response);
        });
        return responses;
    }

    @Override
    public XqhxResponse xqhx(String xqmc) {
        XqhxResponse response = new XqhxResponse();
        Xqk xqk = xqkMapper.selectOne(new LambdaQueryWrapper<Xqk>().eq(Xqk::getXqmc, xqmc));
        response.setXqmc(xqk.getXqmc());
        response.setXqlx(xqk.getXqlx());
        response.setXqxq(xqk.getXqms());
        List<String> tjrc = new ArrayList<>();
        List<String> tjkczy = new ArrayList<>();
        // TODO 随机取推荐科创资源和推荐人才
        List<Rck> rcks = rckMapper.selectList(null);
        Collections.shuffle(rcks);
        for (Rck rck : rcks.subList(0,3)) {
            tjrc.add(rck.getPyxm().trim());
        }
        List<Cyjqcxpt> cyjqcxpts = cyjqcxptMapper.selectList(null).subList(0,2);
        Collections.shuffle(cyjqcxpts);
        for (Cyjqcxpt cyjqcxpt : cyjqcxpts.subList(0,2)) {
            tjkczy.add(cyjqcxpt.getPtmc().trim());
        }
        response.setTjrc(tjrc);
        response.setTjkczy(tjkczy);
        return response;
    }

    @Override
    public void updateLatAndLgt() {
//        List<Qyk> qyks = qykMapper.selectList(null);
//        qyks.forEach(qyk -> {
//            String location = LocationUtils.getLocation(qyk.getQymc());
//            if (StringUtils.isNotEmpty(location)) {
//                String[] split = location.split(",");
//                qyk.setLgt(split[0]);
//                qyk.setLat(split[1]);
//                qykMapper.updateById(qyk);
//            }
//        });
        List<Cyyq> cyyqs = cyyqMapper.selectList(null);
        cyyqs.forEach(cyyq -> {
            String location = LocationUtils.getLocation(cyyq.getZyyq());
            if (StringUtils.isNotEmpty(location)) {
                String[] split = location.split(",");
                cyyq.setLgt(split[0]);
                cyyq.setLat(split[1]);
                cyyqMapper.updateById(cyyq);
            }
        });

    }
}
