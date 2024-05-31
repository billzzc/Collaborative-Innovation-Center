package com.aiit.hexlab.system.service.impl;

import com.aiit.hexlab.common.basic.LambdaQueryWrapperX;
import com.aiit.hexlab.common.utils.StringUtils;
import com.aiit.hexlab.system.domain.entity.*;
import com.aiit.hexlab.system.domain.vo.response.*;
import com.aiit.hexlab.system.mapper.*;
import com.aiit.hexlab.system.service.IMapService;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MapServiceImpl implements IMapService {

    @Resource
    private QykMapper qykMapper;

    @Resource
    private DyrcMapper dyrcMapper;

    @Resource
    private AfrckMapper afrckMapper;

    @Resource
    private CyyqMapper cyyqMapper;

    @Resource
    private CyjqcxptMapper cyjqcxptMapper;

    @Override
    public List<PieResponse> cyqygl(String type) {
        LambdaQueryWrapper<Qyk> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Qyk::getCyly, type);
        List<Qyk> qyks = qykMapper.selectList(wrapper);
        // 根据cyfx分组
        Map<String, Long> collect = qyks.stream()
                                        .collect(Collectors.groupingBy(Qyk::getCyfx, Collectors.counting()));
        List<PieResponse> result = collect.entrySet()
                                          .stream()
                                          .map(entry -> new PieResponse(entry.getKey(), entry.getValue()
                                                                                             .intValue()))
                                          .collect(Collectors.toList());
        return result;
    }

    @Override
    public CyhxjsResponse cyhxjs(String type, String name) {
        CyhxjsResponse response = new CyhxjsResponse();
        LambdaQueryWrapperX<Qyk> wrapper = new LambdaQueryWrapperX<>();
        // 只传了类型
        if (StringUtils.isEmpty(name)) {
            wrapper.eq(Qyk::getCyly, type);
            List<Qyk> qyks = qykMapper.selectList(wrapper);
            // 将cyfx字段过滤出来并且去重
            List<String> cyfxs = qyks.stream()
                                     .map(Qyk::getCyfx)
                                     .distinct()
                                     .collect(Collectors.toList());
            // 放入title中
            response.setTitle(cyfxs);

            // 将qyks中hxjs字段按照顿号隔开拼成一个数组
            Map<String, IntSummaryStatistics> collect = qyks.stream()
                                                            .flatMap(qyk -> Arrays.stream(qyk.getHxjs()
                                                                                             .split("、")))
                                                            .collect(Collectors.groupingBy(String::trim, Collectors.summarizingInt(e -> 1)));
            List<PieResponse> gjc = collect.entrySet()
                                           .stream()
                                           .map(entry -> new PieResponse(entry.getKey(), (int) entry.getValue()
                                                                                                    .getSum()))
                                           .collect(Collectors.toList());
            response.setGjc(gjc);
            return response;
        } else {
            wrapper.clear();
            wrapper.eq(Qyk::getCyly, type)
                   .eq(Qyk::getCyfx, name);
            List<Qyk> qyks = qykMapper.selectList(wrapper);
            List<String> zdfx = qyks.stream()
                                    .filter(e -> StringUtils.isNotBlank(e.getZdfx()) && !e.getZdfx()
                                                                                          .equals("-"))
                                    .map(Qyk::getZdfx)
                                    .distinct()
                                    .collect(Collectors.toList());
            response.setTitle(zdfx);
            // 将qyks中hxjs字段按照顿号隔开拼成一个数组
            Map<String, IntSummaryStatistics> collect = qyks.stream()
                                                            .flatMap(qyk -> Arrays.stream(qyk.getHxjs()
                                                                                             .split("、")))
                                                            .collect(Collectors.groupingBy(String::trim, Collectors.summarizingInt(e -> 1)));
            List<PieResponse> gjc = collect.entrySet()
                                           .stream()
                                           .map(entry -> new PieResponse(entry.getKey(), (int) entry.getValue()
                                                                                                    .getSum()))
                                           .collect(Collectors.toList());
            response.setGjc(gjc);
            return response;
        }
    }

    @Override
    public CyqyResponse cyqy(String type) {
        CyqyResponse cyqyResponse = new CyqyResponse();
        cyqyResponse.setGjgxjs(qykMapper.selectCount(new LambdaQueryWrapper<Qyk>().eq(Qyk::getCyly,type).like(Qyk::getRytd, "国家高新技术")));
        cyqyResponse.setZjtxqy(qykMapper.selectCount(new LambdaQueryWrapper<Qyk>().eq(Qyk::getCyly,type).like(Qyk::getZjtx, "是")));
        cyqyResponse.setXjr(qykMapper.selectCount(new LambdaQueryWrapper<Qyk>().eq(Qyk::getCyly,type).like(Qyk::getRytd, "小巨人")));
        cyqyResponse.setGjkjx(qykMapper.selectCount(new LambdaQueryWrapper<Qyk>().eq(Qyk::getCyly,type).like(Qyk::getRytd, "国家科技型中小")));
        cyqyResponse.setDlqy(qykMapper.selectCount(new LambdaQueryWrapper<Qyk>().eq(Qyk::getCyly,type).like(Qyk::getRytd, "瞪羚")));

        LambdaQueryWrapper<Qyk> wrapper = new LambdaQueryWrapperX<>();
        wrapper.eq(Qyk::getCyly, type);
        List<Qyk> qyks = qykMapper.selectList(wrapper);

        // 查询盯引人才中的匹配公司
        LambdaQueryWrapper<Dyrc> dyrcWrapper = new LambdaQueryWrapperX<>();
        List<Dyrc> dyrcs = dyrcMapper.selectList(null);
        // 过滤出所有匹配公司
        List<String> ppqy = dyrcs.stream()
                                 .map(Dyrc::getPpqy)
                                 .distinct()
                                 .collect(Collectors.toList());
        // qyks根据ppqy的name滤除数据
        List<Qyk> step1 = qyks.stream()
                              .filter(e -> ppqy.contains(e.getQymc()))
                              .collect(Collectors.toList());

        List<String> gzdws = afrckMapper.selectQy();

        // 过滤出只存在与gzdw中的企业
        List<Qyk> step2 = step1.stream()
                               .filter(e -> gzdws.contains(e.getQymc()))
                               .collect(Collectors.toList());

        List<QyResponse> qyList = step2.stream()
                                       .map(e -> new QyResponse(e.getId(), e.getQymc(), e.getZdfx(), e.getZycp()))
                                       .collect(Collectors.toList());
        cyqyResponse.setQy(qyList);
        return cyqyResponse;
    }

    @Override
    public IndexResponse index(String type) {
        IndexResponse response = new IndexResponse();
        List<MapResponse> mapList = new ArrayList<>();
        LambdaQueryWrapper<Qyk> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Qyk::getCyly, type);
        List<Qyk> qyks = qykMapper.selectList(wrapper);
        response.setCyzdqy(qyks.size());
        response.setZjtxqy(qykMapper.selectCount(new LambdaQueryWrapper<Qyk>().eq(Qyk::getCyly,type).like(Qyk::getZjtx, "是")));
        response.setCydyrc(dyrcMapper.selectCount(new LambdaQueryWrapper<Dyrc>().eq(Dyrc::getCyly, type)));
        response.setCyxyrc(afrckMapper.selectCount(new LambdaQueryWrapper<Afrck>().like(Afrck::getLb, type)));
        // 将qyks中hxjs字段按照顿号隔开拼成一个数组
        Map<String, IntSummaryStatistics> collect = qyks.stream()
                                                        .flatMap(qyk -> Arrays.stream(qyk.getHxjs()
                                                                                         .split("、")))
                                                        .collect(Collectors.groupingBy(String::trim, Collectors.summarizingInt(e -> 1)));
        response.setCyhxjsly(collect.size());

        List<Cyjqcxpt> cyjqcxpts = cyjqcxptMapper.selectList(new LambdaQueryWrapper<Cyjqcxpt>().eq(Cyjqcxpt::getCyly, type));
        List<Cyyq> cyyqs = cyyqMapper.selectList(new LambdaQueryWrapper<Cyyq>().eq(Cyyq::getCyly, type));

        for (Qyk qyk : qyks) {
            MapResponse mapResponse = new MapResponse();
            mapResponse.setType("0");
            mapResponse.setLat(qyk.getLat());
            mapResponse.setLgt(qyk.getLgt());
            mapResponse.setName(qyk.getQymc());
            mapResponse.setValue1(formatZjtx(qyk));
            mapResponse.setValue2(qyk.getZycp());
            mapResponse.setValue3(qyk.getCyfx());
            mapList.add(mapResponse);
        }
        for (Cyyq cyyq : cyyqs) {
            MapResponse mapResponse = new MapResponse();
            mapResponse.setType("1");
            mapResponse.setLat(cyyq.getLat());
            mapResponse.setLgt(cyyq.getLgt());
            mapResponse.setName(cyyq.getYqmc());
            mapResponse.setValue1(cyyq.getZydw());
            mapResponse.setValue2(type.equals("智能物联")?cyyq.getZdfx():cyyq.getCyfx());
            mapResponse.setValue3(cyyq.getCyly());
            mapList.add(mapResponse);
        }
        for (Cyjqcxpt cyjqcxpt : cyjqcxpts) {
            MapResponse mapResponse = new MapResponse();
            mapResponse.setType("2");
            mapResponse.setLat(cyjqcxpt.getLat());
            mapResponse.setLgt(cyjqcxpt.getLgt());
            mapResponse.setName(cyjqcxpt.getPtmc());
            mapResponse.setValue1(cyjqcxpt.getYtjg());
            mapResponse.setValue2(cyjqcxpt.getLx());
            mapResponse.setValue3(cyjqcxpt.getCyfx());
            mapList.add(mapResponse);
        }
        response.setMap(mapList);
        return response;
    }

    @Override
    public List<CyxyrcResponse> cyxyrc(String type) {
        List<CyxyrcResponse> result = new ArrayList<>();
        LambdaQueryWrapper<Afrck> wrapper = new LambdaQueryWrapperX<>();
        wrapper.like(Afrck::getLb, type);
        List<Afrck> afrcks = afrckMapper.selectList(wrapper);

        List<Qyk> qyks = qykMapper.selectList(null);
        // 之过滤出公司名称为key，公司Id为value的map
        Map<String, Long> qykMap = new HashMap<>();
        for (Qyk qyk : qyks) {
            qykMap.put(qyk.getQymc(), qyk.getId());
        }
        List<Afrck> collect = afrcks.stream()
                                    .filter(e -> qykMap.containsKey(e.getGzdw()))
                                    .collect(Collectors.toList());

        result = collect.stream()
                                                .map(e -> new CyxyrcResponse(e.getId(), e.getXm(), e.getZy(), e.getXw(), e.getRcrdjb()))
                                                .collect(Collectors.toList());

        return result;
    }

    @Override
    public CydyrcResponse cyrck(String type) {
        CydyrcResponse cycResponse = new CydyrcResponse();

        cycResponse.setNlfb(afrckMapper.selectNlfb(type));

        List<RcfbResponse> rcfbResponses = afrckMapper.selectRcfb(type);
        cycResponse.setRcfb(rcfbResponses);

        cycResponse.setXwfb(afrckMapper.selectXwfb(type));

        return cycResponse;
    }

    @Override
    public List<CyyqResponse> cyyq(String type) {
        LambdaQueryWrapper<Cyyq> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Cyyq::getCyly, type);
        List<Cyyq> cyyqs = cyyqMapper.selectList(wrapper);
        return cyyqs.stream()
                    .map(e -> new CyyqResponse(e.getId(), e.getYqmc(),
                            type.equals("智能物联")?e.getZdfx():e.getCyfx(), e.getZydw()))
                    .collect(Collectors.toList());
    }

    @Override
    public List<KcptResponse> kcpt(String type) {
        LambdaQueryWrapper<Cyjqcxpt> wrapper = new LambdaQueryWrapperX<>();
        wrapper.eq(Cyjqcxpt::getCyly, type);
        List<Cyjqcxpt> cyjqcxpts = cyjqcxptMapper.selectList(wrapper);
        return cyjqcxpts.stream()
                        .map(e -> new KcptResponse(e.getId(), e.getPtmc(), e.getYtjg(), e.getCyly(), e.getLx(), e.getXfsd()))
                        .collect(Collectors.toList());
    }

    @Override
    public DyrchxResponse rchx(Long id) {
        DyrchxResponse response = new DyrchxResponse();
        Dyrc dyrc = dyrcMapper.selectById(id);
        response.setXmpy(dyrc.getXmpy());
        response.setCxcy(dyrc.getCxcy());
        response.setZls(dyrc.getZlsl());
        response.setXszc(dyrc.getXszc());
        response.setRcjb(dyrc.getRcjb());
        response.setXzgj(dyrc.getXzdgj());
        response.setZyly(dyrc.getYjly());
        response.setDbcg(dyrc.getDbcg());
        List<String> temp = new ArrayList<>();
        if (!StringUtils.isEmpty(dyrc.getJslya())) {
            temp.add(dyrc.getJslya());
        }
        if (!StringUtils.isEmpty(dyrc.getJslyb())) {
            temp.add(dyrc.getJslyb());
        }
        if (!StringUtils.isEmpty(dyrc.getJslyc())) {
            temp.add(dyrc.getJslyc());
        }
        response.setHxjs(String.join("、", temp));
        // 根据ppqy搜索qyk中的企业
        if (!StringUtils.isEmpty(dyrc.getPpqy())) {
            Qyk qyk = qykMapper.selectOne(new LambdaQueryWrapper<Qyk>().eq(Qyk::getQymc, dyrc.getPpqy()
                                                                                             .trim()));
            if (qyk != null) {
                QyListHxResponse qyListHxResponse = new QyListHxResponse();
                qyListHxResponse.setId(qyk.getId());
                qyListHxResponse.setName(qyk.getQymc());
                qyListHxResponse.setCyly(qyk.getCyly());
                qyListHxResponse.setQylx(qyk.getRytd());
                List<QyListHxResponse> list = new ArrayList<>();
                list.add(qyListHxResponse);
                response.setQy(list);
            }
        }
        return response;
    }

    @Override
    public QyhxResponse qyhx(Long id) {
        QyhxResponse response = new QyhxResponse();
        Qyk qyk = qykMapper.selectById(id);
        response.setName(qyk.getQymc());
        response.setQylb(qyk.getRytd());
        response.setCyfx(qyk.getCyfx());
        response.setCyly(qyk.getCyly());
        response.setHxjs(qyk.getHxjs());
        // 根据公司名去afrck中搜索人才
        List<Afrck> afrcks = afrckMapper.selectList(new LambdaQueryWrapper<Afrck>().eq(Afrck::getGzdw, qyk.getQymc()));
        if (afrcks.size() > 0) {
            List<RcListHxResponse> rcListHxResponses = afrcks.stream()
                                                             .map(e -> new RcListHxResponse(e.getId(), e.getXm(), e.getXw(), qyk.getCyfx(), e.getZy()))
                                                             .collect(Collectors.toList());
            response.setQyzdrc(rcListHxResponses);
        }
        // 根据公司名去dyrc中搜索
        List<Dyrc> dyrcks = dyrcMapper.selectList(new LambdaQueryWrapper<Dyrc>().like(Dyrc::getPpqy, qyk.getQymc()));
        if (dyrcks.size() > 0) {
            List<RcListHxResponse> rcListHxResponses = dyrcks.stream()
                                                             .map(e -> new RcListHxResponse(e.getId(), e.getXmpy(), e.getXszc(), e.getYjly(), e.getJslya()))
                                                             .collect(Collectors.toList());
            response.setQyzdrc(rcListHxResponses);
       }
        return response;
    }

    @Override
    public ZkrchxResponse rckrchx(Long id) {
        ZkrchxResponse response = new ZkrchxResponse();
        List<QyListHxResponse> qyListHxResponses = new ArrayList<>();
        Afrck afrck = afrckMapper.selectOne(new LambdaQueryWrapper<Afrck>().eq(Afrck::getId, id));
        response.setName(afrck.getXm());
        response.setRcjb(afrck.getRcrdjb());
        response.setSex(afrck.getSex());
        response.setXw(afrck.getXw());
        response.setGj(afrck.getGj());
        response.setZzmm(afrck.getZzmm());
        response.setByyx(afrck.getByyx());
        response.setZyly(afrck.getZy());
        response.setXzzw(afrck.getXzzw());
        response.setJszc(afrck.getZc());
        response.setHxjs("暂无");
        // 根据gzdw搜索企业
        Qyk qyk = qykMapper.selectOne(new LambdaQueryWrapper<Qyk>().eq(Qyk::getQymc, afrck.getGzdw()));
        if (qyk != null) {
            QyListHxResponse qyListHxResponse = new QyListHxResponse();
            qyListHxResponse.setId(qyk.getId());
            qyListHxResponse.setName(qyk.getQymc());
            qyListHxResponse.setCyly(qyk.getCyly());
            qyListHxResponse.setQylx(qyk.getRytd());
            qyListHxResponses.add(qyListHxResponse);
        }
        response.setQy(qyListHxResponses);
        return response;
    }

    @Override
    public CyyqhxResponse cyyqhx(Long id) {
        CyyqhxResponse response = new CyyqhxResponse();
        Cyyq cyyq = cyyqMapper.selectById(id);
        response.setName(cyyq.getYqmc());
        response.setCyly(cyyq.getCyly());
        response.setZdhy(cyyq.getZdfx());
        response.setXfsd(cyyq.getXfsd());
        response.setCyfx(cyyq.getCyfx());
        response.setTdxz(cyyq.getTdxz());
        response.setZdqy(cyyq.getZdqy());
        // 根据产业园区名称去dyrc查询ppyq
        List<Dyrc> dyrcs = dyrcMapper.selectList(new LambdaQueryWrapper<Dyrc>().like(Dyrc::getPpyq, cyyq.getYqmc()));
        if (dyrcs.size() > 0) {
            List<RcListHxResponse> rcListHxResponses = dyrcs.stream()
                                                            .map(e -> new RcListHxResponse(e.getId(), e.getXmpy(), e.getXszc(), e.getYjly(), e.getJslya()))
                                                            .collect(Collectors.toList());
            response.setTjrc(rcListHxResponses);
        }
        return response;
    }

    @Override
    public KcpthxResponse kcpthx(Long id) {
        KcpthxResponse response = new KcpthxResponse();
        Cyjqcxpt cyjqcxpt = cyjqcxptMapper.selectById(id);
        response.setName(cyjqcxpt.getPtmc());
        response.setPtlx(cyjqcxpt.getLx());
        response.setYtjg(cyjqcxpt.getYtjg());
        response.setCyly(cyjqcxpt.getCyly());
        response.setHxjs(cyjqcxpt.getHxjs());
        response.setZdfx(cyjqcxpt.getZdfx());
        response.setXfsd(cyjqcxpt.getXfsd());
        response.setCyfx(cyjqcxpt.getCyfx());
        // 根据科创平台名称去dyrc查询ppcxpt
        List<Dyrc> dyrcs = dyrcMapper.selectList(new LambdaQueryWrapper<Dyrc>().like(Dyrc::getPpcxpt, cyjqcxpt.getPtmc()));
        if (dyrcs.size() > 0) {
            List<RcListHxResponse> rcListHxResponses = dyrcs.stream()
                                                            .map(e -> new RcListHxResponse(e.getId(), e.getXmpy(), e.getXszc(), e.getYjly(), e.getJslya()))
                                                            .collect(Collectors.toList());
            response.setTjrc(rcListHxResponses);
        }
        return response;
    }

    private String formatZjtx(Qyk qyk) {
        if ("是".equals(qyk.getZjtx())) {
            if (StringUtils.isNotEmpty(qyk.getRytd())) {
                if (qyk.getRytd().contains("专精特新")) {
                    return qyk.getRytd();
                } else {
                    return qyk.getRytd() + ", 专精特新";
                }
            } else {
                return "专精特新";
            }
        }
        return qyk.getRytd();
    }
}
