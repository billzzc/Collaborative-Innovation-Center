package com.aiit.hexlab.system.service.impl;

import com.aiit.hexlab.common.basic.LambdaQueryWrapperX;
import com.aiit.hexlab.common.utils.StringUtils;
import com.aiit.hexlab.system.LocationUtils;
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
        List<PieResponse> result = new ArrayList<>();
        // 根据cyfx分组
//        if (type.equals("智能物联")) {
//            Map<String, Long> collect = qyks.stream()
//                    .collect(Collectors.groupingBy(Qyk::getZdfx, Collectors.counting()));
//            result = collect.entrySet()
//                    .stream()
//                    .map(entry -> new PieResponse(entry.getKey(), entry.getValue()
//                            .intValue()))
//                    .collect(Collectors.toList());
//        } else {
//            Map<String, Long> collect = qyks.stream()
//                    .collect(Collectors.groupingBy(Qyk::getCyfx, Collectors.counting()));
//            result = collect.entrySet()
//                    .stream()
//                    .map(entry -> new PieResponse(entry.getKey(), entry.getValue()
//                            .intValue()))
//                    .collect(Collectors.toList());
//        }

        // 将所有产业方向用顿号隔开，通过stream做
        List<String> cyfxList = qyks.stream()
                                    .map(Qyk::getCyfx)
                                    .filter(cyfx -> StringUtils.isNotEmpty(cyfx))
                                    .map(String::trim)
                                    .flatMap(cyfx -> Arrays.stream(cyfx.split("、")))
                                    .distinct()
                                    .collect(Collectors.toList());

        for (String s : cyfxList) {
            Integer i = qykMapper.selectCount(new LambdaQueryWrapper<Qyk>().like(Qyk::getCyfx, s));
            result.add(new PieResponse(s, i));
        }

        return result;
    }

    @Override
    public CyhxjsResponse cyhxjs(String type, String name) {
        CyhxjsResponse response = new CyhxjsResponse();
        LambdaQueryWrapperX<Qyk> wrapper = new LambdaQueryWrapperX<>();
        List<Qyk> qyks = new ArrayList<>();
        List<String> title = new ArrayList<>();
        // 只传了类型
        if (StringUtils.isEmpty(name)) {

            wrapper.eq(Qyk::getCyly, type);
            qyks = qykMapper.selectList(wrapper);
            // 将cyfx字段过滤出来并且去重
            title = qyks.stream()
                        .map(Qyk::getCyfx)
                        .filter(cyfx -> StringUtils.isNotEmpty(cyfx))
                        .map(String::trim)
                        .flatMap(cyfx -> Arrays.stream(cyfx.split("、")))
                        .distinct()
                        .collect(Collectors.toList());
            // 放入title中
            response.setTitle(title);

            // 将qyks中hxjs字段按照顿号隔开拼成一个数组
            Map<String, IntSummaryStatistics> collect = qyks.stream()
                                                            .flatMap(qyk -> Arrays.stream(Optional.ofNullable(qyk.getHxjs())
                                                                                                  .orElse("")
                                                                                                  .split("、")))
                                                            .filter(s -> !s.trim()
                                                                           .isEmpty())
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
                   .like(Qyk::getCyfx, name);
            qyks = qykMapper.selectList(wrapper);
            title = qyks.stream()
                        .map(Qyk::getZdfx)
                        .filter(zdfx -> StringUtils.isNotEmpty(zdfx) && !zdfx.equals("-"))
                        .map(String::trim)
                        .flatMap(zdfx -> Arrays.stream(zdfx.split("、")))
                        .distinct()
                        .collect(Collectors.toList());

//            response.setTitle(title.size() > 3 ? title.subList(0, 3) : title);
            response.setTitle(title);
            // 将qyks中hxjs字段按照顿号隔开拼成一个数组
            wrapper.clear();
            wrapper.eq(Qyk::getCyly, type)
                   .and(q -> q.like(Qyk::getXfsd, name)
                              .or()
                              .like(Qyk::getCyfx, name)
                              .or()
                              .like(Qyk::getZdfx, name));
            qyks = qykMapper.selectList(wrapper);
            Map<String, IntSummaryStatistics> collect = qyks.stream()
                                                            .flatMap(qyk -> Arrays.stream(Optional.ofNullable(qyk.getHxjs())
                                                                                                  .orElse("")
                                                                                                  .split("、")))
                                                            .filter(s -> !s.trim()
                                                                           .isEmpty())
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
        cyqyResponse.setGjgxjs(qykMapper.selectCount(new LambdaQueryWrapper<Qyk>().eq(Qyk::getCyly, type)
                                                                                  .like(Qyk::getRytd, "国家高新技术")));
        cyqyResponse.setZjtxqy(qykMapper.selectCount(new LambdaQueryWrapper<Qyk>().eq(Qyk::getCyly, type)
                                                                                  .like(Qyk::getZjtx, "是")));
        cyqyResponse.setXjr(qykMapper.selectCount(new LambdaQueryWrapper<Qyk>().eq(Qyk::getCyly, type)
                                                                               .like(Qyk::getRytd, "小巨人")));
        cyqyResponse.setGjkjx(qykMapper.selectCount(new LambdaQueryWrapper<Qyk>().eq(Qyk::getCyly, type)
                                                                                 .like(Qyk::getRytd, "国家科技型中小")));
        cyqyResponse.setDlqy(qykMapper.selectCount(new LambdaQueryWrapper<Qyk>().eq(Qyk::getCyly, type)
                                                                                .like(Qyk::getRytd, "瞪羚")));

        LambdaQueryWrapper<Qyk> wrapper = new LambdaQueryWrapperX<>();
        wrapper.eq(Qyk::getCyly, type);
        List<Qyk> qyks = qykMapper.selectList(wrapper);

        if (type.equals("生命健康") || type.equals("智能物联")) {
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
        } else {
            List<QyResponse> qyList = qyks.stream()
                                          .map(e -> new QyResponse(e.getId(), e.getQymc(), e.getZdfx(), e.getZycp()))
                                          .collect(Collectors.toList());
            cyqyResponse.setQy(qyList);
        }

        return cyqyResponse;
    }

    @Override
    public IndexResponse index(String type, String name) {
        IndexResponse response = new IndexResponse();
        List<MapResponse> mapList = new ArrayList<>();
        LambdaQueryWrapperX<Qyk> wrapper = new LambdaQueryWrapperX<>();
        LambdaQueryWrapper<Cyjqcxpt> ptWrapper = new LambdaQueryWrapper<Cyjqcxpt>();
        LambdaQueryWrapper<Cyyq> yqWrapper = new LambdaQueryWrapper<Cyyq>();
        wrapper.eq(Qyk::getCyly, type);
        ptWrapper.eq(Cyjqcxpt::getCyly, type);
        yqWrapper.eq(Cyyq::getCyly, type);
        if (StringUtils.isNotEmpty(name)) {
            wrapper.and(e -> e.eq(Qyk::getCyfx, name)
                              .or()
                              .eq(Qyk::getZdfx, name)
                              .or()
                              .eq(Qyk::getXfsd, name));
            ptWrapper.and(e -> e.eq(Cyjqcxpt::getCyfx, name)
                                .or()
                                .eq(Cyjqcxpt::getZdfx, name)
                                .or()
                                .eq(Cyjqcxpt::getXfsd, name));
            yqWrapper.and(e -> e.eq(Cyyq::getCyfx, name)
                                .or()
                                .eq(Cyyq::getZdfx, name)
                                .or()
                                .eq(Cyyq::getXfsd, name));
        }
        List<Qyk> qyks = qykMapper.selectList(wrapper);
        response.setCyzdqy(qyks.size());
        response.setZjtxqy(qykMapper.selectCount(wrapper.and(e -> e.eq(Qyk::getZjtx, "是"))));
        response.setCydyrc(dyrcMapper.selectCount(new LambdaQueryWrapper<Dyrc>().eq(Dyrc::getCyly, type)));
        response.setCyxyrc(afrckMapper.selectCount(new LambdaQueryWrapper<Afrck>().like(Afrck::getLb, type)));
        // 将qyks中hxjs字段按照顿号隔开拼成一个数组
        Map<String, IntSummaryStatistics> collect = qyks.stream()
                                                        .flatMap(qyk -> Arrays.stream(Optional.ofNullable(qyk.getHxjs())
                                                                                              .orElse("")
                                                                                              .split("、")))
                                                        .filter(s -> !s.trim()
                                                                       .isEmpty())
                                                        .collect(Collectors.groupingBy(String::trim, Collectors.summarizingInt(e -> 1)));
        response.setCyhxjsly(collect.size());


        List<Cyjqcxpt> cyjqcxpts = cyjqcxptMapper.selectList(ptWrapper);
        List<Cyyq> cyyqs = cyyqMapper.selectList(yqWrapper);

        List<String> qymcs = qyks.stream()
                                 .map(e -> e.getQymc()
                                            .trim())
                                 .collect(Collectors.toList());
        List<Dyrc> dyrcs = dyrcMapper.selectList(new LambdaQueryWrapper<Dyrc>().eq(Dyrc::getCyly, type)
                                                                               .eq(Dyrc::getYjzt, "成功匹配"));
        response.setCgpprc(dyrcs.size());

        for (Qyk qyk : qyks) {
            MapResponse mapResponse = new MapResponse();
            mapResponse.setId(qyk.getId());
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
            mapResponse.setId(cyyq.getId());
            mapResponse.setType("1");
            mapResponse.setLat(cyyq.getLat());
            mapResponse.setLgt(cyyq.getLgt());
            mapResponse.setName(cyyq.getYqmc());
            mapResponse.setValue1(cyyq.getZydw());
//            mapResponse.setValue2(type.equals("智能物联") ? cyyq.getZdfx() : cyyq.getCyfx());
            mapResponse.setValue2(cyyq.getCyfx());
            mapResponse.setValue3(cyyq.getCyly());
            mapList.add(mapResponse);
        }
        for (Cyjqcxpt cyjqcxpt : cyjqcxpts) {
            MapResponse mapResponse = new MapResponse();
            mapResponse.setId(cyjqcxpt.getId());
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
//                        type.equals("智能物联") ? e.getZdfx() : e.getCyfx(), e.getZydw()))
                            e.getCyfx(), e.getZydw()))
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
    public DyrchxResponse rchx(Long id, String type) {
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
        response.setByyx(dyrc.getZgxlbyyx());
        response.setGzdw(dyrc.getXgzdw());
        response.setGzzc(dyrc.getGzzj());
        response.setZt(dyrc.getYjzt());
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
        if (StringUtils.isNotEmpty(dyrc.getPpqy())) {
            Qyk qyk = qykMapper.selectOne(new LambdaQueryWrapper<Qyk>().eq(Qyk::getQymc, dyrc.getPpqy()
                                                                                             .trim())
                                                                       .eq(Qyk::getCyly, type));
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
        if (StringUtils.isNotEmpty(dyrc.getPpcxpt())) {
            Cyjqcxpt cyjqcxpt = cyjqcxptMapper.selectOne(new LambdaQueryWrapper<Cyjqcxpt>().eq(Cyjqcxpt::getPtmc, dyrc.getPpcxpt()
                                                                                                                      .trim())
                                                                                           .eq(Cyjqcxpt::getCyly, type));
            if (cyjqcxpt != null) {
                KcptResponse cyjqcxptResponse = new KcptResponse();
                cyjqcxptResponse.setId(cyjqcxpt.getId());
                cyjqcxptResponse.setYtjg(cyjqcxpt.getYtjg());
                cyjqcxptResponse.setPtlx(cyjqcxpt.getLx());
                cyjqcxptResponse.setXfsd(cyjqcxpt.getXfsd());
                cyjqcxptResponse.setCyly(cyjqcxpt.getCyly());
                cyjqcxptResponse.setPtmc(cyjqcxpt.getPtmc());
                List<KcptResponse> list = new ArrayList<>();
                list.add(cyjqcxptResponse);
                response.setKcpt(list);
            }
        }
        if (StringUtils.isNotEmpty(dyrc.getPpyq())) {
            Cyyq cyyq = cyyqMapper.selectOne(new LambdaQueryWrapper<Cyyq>().eq(Cyyq::getYqmc, dyrc.getPpyq()
                                                                                                  .trim()));
            if (cyyq != null) {
                CyyqResponse cyyqResponse = new CyyqResponse();
                cyyqResponse.setId(cyyq.getId());
                cyyqResponse.setYqmc(cyyq.getYqmc());
                cyyqResponse.setCyfx(cyyq.getCyfx());
                cyyqResponse.setZydw(cyyq.getZydw());
                List<CyyqResponse> list = new ArrayList<>();
                list.add(cyyqResponse);
                response.setYq(list);
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
        response.setZdfx(qyk.getZdfx());
        response.setXfsd(qyk.getXfsd());
        response.setZjtx(qyk.getZjtx());
        response.setJyfw(qyk.getJyfw());
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
            response.setTjrc(rcListHxResponses);
        }
        return response;
    }

    @Override
    public ZkrchxResponse rckrchx(Long id, String type) {
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
        Qyk qyk = qykMapper.selectOne(new LambdaQueryWrapper<Qyk>().eq(Qyk::getQymc, afrck.getGzdw())
                                                                   .eq(Qyk::getCyly, type));
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

    @Override
    public void location(String type) {
        if (type.equals("0")) {
            List<Cyyq> cyyqs = cyyqMapper.selectList(null);
            cyyqs.forEach(cyyq -> {
                String location = LocationUtils.getLocation(cyyq.getDz());
                if (StringUtils.isNotEmpty(location)) {
                    String[] split = location.split(",");
                    cyyq.setLgt(split[0]);
                    cyyq.setLat(split[1]);
                    cyyqMapper.updateById(cyyq);
                }
            });
        }
        if (type.equals("1")) {
            List<Cyjqcxpt> cyjqcxpts = cyjqcxptMapper.selectList(null);
            cyjqcxpts.forEach(cyjqcxpt -> {
                String location = LocationUtils.getLocation(cyjqcxpt.getDz()
                                                                    .trim());
                if (StringUtils.isNotEmpty(location)) {
                    String[] split = location.split(",");
                    cyjqcxpt.setLgt(split[0]);
                    cyjqcxpt.setLat(split[1]);
                    cyjqcxptMapper.updateById(cyjqcxpt);
                }
            });
        }
        if (type.equals("2")) {
            List<Qyk> qyks = qykMapper.selectList(null);
            qyks.forEach(qyk -> {
                String location = LocationUtils.getLocation(qyk.getDz()
                                                               .trim());
                if (StringUtils.isNotEmpty(location)) {
                    String[] split = location.split(",");
                    qyk.setLgt(split[0]);
                    qyk.setLat(split[1]);
                    qykMapper.updateById(qyk);
                }
            });
        }
    }

    private String formatZjtx(Qyk qyk) {
        if ("是".equals(qyk.getZjtx())) {
            if (StringUtils.isNotEmpty(qyk.getRytd())) {
                if (qyk.getRytd()
                       .contains("专精特新")) {
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
