package com.aiit.hexlab.system.service.impl;

import com.aiit.hexlab.common.basic.LambdaQueryWrapperX;
import com.aiit.hexlab.system.domain.entity.Qyk;
import com.aiit.hexlab.system.domain.vo.response.*;
import com.aiit.hexlab.system.mapper.QykMapper;
import com.aiit.hexlab.system.service.IMapService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MapServiceImpl implements IMapService {

    @Resource
    private QykMapper qykMapper;

    @Override
    public List<PieResponse> cyqygl(String type) {
        LambdaQueryWrapper<Qyk> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Qyk::getCyly, type);
        List<Qyk> qyks = qykMapper.selectList(wrapper);
        // 根据cyfx分组
        Map<String, Long> collect = qyks.stream()
                                        .collect(Collectors.groupingBy(Qyk::getCyfx, Collectors.counting()));
        List<PieResponse> result = collect.entrySet().stream()
                                            .map(entry -> new PieResponse(entry.getKey(), entry.getValue().intValue()))
                                            .collect(Collectors.toList());
        return result;
    }

    @Override
    public CyhxjsResponse cyhxjs(String type, String name) {
        LambdaQueryWrapperX<Qyk> wrapper = new LambdaQueryWrapperX<>();


        return null;
    }

    @Override
    public CyqyResponse cyqy(String type) {

        return null;
    }

    @Override
    public MapResponse index(String type) {
        return null;
    }

    @Override
    public List<CyxyrcResponse> cyxyrc(String type) {
        return null;
    }

    @Override
    public CydyrcResponse cydyrc(String type) {
        return null;
    }

    @Override
    public List<CyyqResponse> cyyq(String type) {
        return null;
    }

    @Override
    public List<KcptResponse> kcpt(String type) {
        return null;
    }

    @Override
    public DyrchxResponse rchx(Long id) {
        return null;
    }

    @Override
    public QyhxResponse qyhx(Long id) {
        return null;
    }

    @Override
    public ZkrchxResponse rckrchx(Long id) {
        return null;
    }

    @Override
    public CyyqhxResponse cyyqhx(Long id) {
        return null;
    }

    @Override
    public KcpthxResponse kcpthx(Long id) {
        return null;
    }
}
