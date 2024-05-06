package com.aiit.hexlab.system.service.impl;

import com.aiit.hexlab.common.utils.StringUtils;
import com.aiit.hexlab.system.domain.entity.*;
import com.aiit.hexlab.system.domain.vo.response.index.*;
import com.aiit.hexlab.system.mapper.*;
import com.aiit.hexlab.system.service.IIndexService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class IndexServiceImpl implements IIndexService {

    public static final List<String> xmlx = Arrays.asList("盯引项目","科创项目","揭榜挂帅");

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
    public List<CyrcxqResponse> cyrcxq() {
        return xgjqgwMapper.groupByCy();
    }

    @Override
    public List<CyjqgwResponse> cyjqgw() {
        List<CyjqgwResponse> list = new ArrayList<>();
        List<Xgjqgw> xgjqgws = xgjqgwMapper.selectList(null);
        xgjqgws.forEach(xgjqgw -> {
            CyjqgwResponse cyjqgwResponse = new CyjqgwResponse();
            cyjqgwResponse.setCy(xgjqgw.getCy());
            cyjqgwResponse.setGw(xgjqgw.getGwmc());
            list.add(cyjqgwResponse);
        });
        return list;
    }

    @Override
    public ZdxmResponse zdxm() {
        ZdxmResponse zdxmResponse = new ZdxmResponse();
        List<XmResponse> xmList = new ArrayList<>();
        List<Xmk> xmks = xmkMapper.selectList(null);
        xmks.forEach(xmk -> {
            XmResponse xmResponse = new XmResponse();
            xmResponse.setXmmc(xmk.getXmmc());
            xmResponse.setCyly(xmk.getCyly());
            xmResponse.setCyfx(xmk.getCyfx());
            xmList.add(xmResponse);
        });
        zdxmResponse.setXmList(xmList);
        zdxmResponse.setDyxm(xmkMapper.selectCount(new LambdaQueryWrapper<Xmk>().like(Xmk::getXmlx,"盯引")));
        zdxmResponse.setJbgsxm(xmkMapper.selectCount(new LambdaQueryWrapper<Xmk>().like(Xmk::getXmlx,"揭榜挂帅")));
        zdxmResponse.setKcxm(xmkMapper.selectCount(new LambdaQueryWrapper<Xmk>().like(Xmk::getXmlx,"科创")));
        return zdxmResponse;
    }

    @Override
    public IndexResponse index() {
        IndexResponse indexResponse = new IndexResponse();
        indexResponse.setZdxmsl(xmkMapper.selectCount(null));
        indexResponse.setZdrcrkl(rckMapper.selectCount(null));
        indexResponse.setCyrcxql(31.4);
        List<DtzbResponse> maps = rckMapper.select4maps();
        indexResponse.setMaps(maps);
        return indexResponse;
    }

    @Override
    public List<QqhrzdrcResponse> qqhrzdrc() {
        return rckMapper.select4Qqhrzdrc();
    }

    @Override
    public BdcyrcfxResponse bdcyrcfx() {
        BdcyrcfxResponse response = new BdcyrcfxResponse();
        response.setCyrc(rckMapper.selectCount(new LambdaQueryWrapper<Rck>().eq(Rck::getCxcy, "创业")));
        response.setCxrc(rckMapper.selectCount(new LambdaQueryWrapper<Rck>().eq(Rck::getCxcy, "创新")));
        List<PieResponse> pieResponses = rckMapper.select4AgePie();
        for (PieResponse pieResponse : pieResponses) {
            if (StringUtils.isNull(pieResponse.getMc())) {
                pieResponse.setMc("未知");
            }
        }
        response.setAgePie(pieResponses);
        List<Rck> rcks = rckMapper.selectList(new QueryWrapper<Rck>().select("id, gzzj"));
        Integer sum = rcks.size();
        List<PieResponse> lxfb = new ArrayList<>();
        PieResponse jsry = new PieResponse();
        jsry.setMc("技术人员");
        PieResponse qt = new PieResponse();
        qt.setMc("其他");
        PieResponse gjglry = new PieResponse();
        gjglry.setMc("高级管理人员");
        PieResponse yjry = new PieResponse();
        yjry.setMc("研究人员");
        PieResponse xsjs = new PieResponse();
        xsjs.setMc("学术教授");
        for (Rck rck : rcks) {
            if ("总监".equals(rck.getGzzj()) || "经理".equals(rck.getGzzj()) || "主管".equals(rck.getGzzj())
                    || "副总裁".equals(rck.getGzzj()) || "首席执行官".equals(rck.getGzzj())) {
                gjglry.setSl(gjglry.getSl() + 1);
            } else if ("教授".equals(rck.getGzzj()) || "副教授".equals(rck.getGzzj()) || "助理教授".equals(rck.getGzzj())
                    || "客座教授".equals(rck.getGzzj())) {
                xsjs.setSl(xsjs.getSl() + 1);
            } else if ("研究员".equals(rck.getGzzj()) || "研究助理".equals(rck.getGzzj()) || "讲师".equals(rck.getGzzj())
                    || "博士后研究员".equals(rck.getGzzj()) || "科学家".equals(rck.getGzzj()) || "首席科学家".equals(rck.getGzzj())) {
                yjry.setSl(yjry.getSl() + 1);
            } else if ("工程师".equals(rck.getGzzj()) || "顾问".equals(rck.getGzzj()) || "首席技术官".equals(rck.getGzzj())) {
                jsry.setSl(jsry.getSl() + 1);
            } else {
                qt.setSl(qt.getSl() + 1);
            }
        }
        if (sum != 0) {
            jsry.setZb(jsry.getSl() * 1.0 / sum);
            qt.setZb(qt.getSl() * 1.0 / sum);
            gjglry.setZb(gjglry.getSl() * 1.0 / sum);
            yjry.setZb(yjry.getSl() * 1.0 / sum);
            xsjs.setZb(xsjs.getSl() * 1.0/ sum);
        }
        lxfb.add(jsry);
        lxfb.add(qt);
        lxfb.add(gjglry);
        lxfb.add(yjry);
        lxfb.add(xsjs);
        response.setTypePie(lxfb);
        return response;
    }

    @Override
    public List<XflyrcfxResponse> xflyrcfx() {
        List<XflyrcfxResponse> xflyrcfxResponses = rckMapper.select4Xflyrcfx();
        if (xflyrcfxResponses != null) {
            for (XflyrcfxResponse xflyrcfxResponse : xflyrcfxResponses) {
                if (StringUtils.isEmpty(xflyrcfxResponse.getX())) {
                    xflyrcfxResponse.setX("未知");
                }
            }
        }
        return xflyrcfxResponses;
    }

    @Override
    public RchxResponse rchx(String rcxm) {
        RchxResponse rchxResponse = new RchxResponse();
        if (StringUtils.isNotEmpty(rcxm)) {
            Rck rck = rckMapper.selectOne(new LambdaQueryWrapper<Rck>().eq(Rck::getPyxm, rcxm.trim()));
            if (rck != null) {
                rchxResponse.setPyxm(rcxm);
                rchxResponse.setZwxm(rck.getZwxm());
                rchxResponse.setDbcg(rck.getDbcg());
                rchxResponse.setZlsl(rck.getZlsl());
                rchxResponse.setRcjb(rck.getRcjb());
                rchxResponse.setXszc(rck.getXszc());
                rchxResponse.setXzgj(rck.getXzgj());
                rchxResponse.setGzzj(rck.getGzzj());
                rchxResponse.setCxcy(rck.getCxcy() + "人才");
                rchxResponse.setHxjs(Arrays.asList(rck.getJslya(),rck.getJslyb(),rck.getJslyc()));
                if (StringUtils.isNotEmpty(rck.getPpgs())) {
                    rchxResponse.setPpqy(Arrays.asList(rck.getPpgs().trim()));
                }
            }
        }
        return rchxResponse;
    }

    @Override
    public XmhxResponse xmhx(String xmmc) {
        XmhxResponse xmhxResponse = new XmhxResponse();
        if (StringUtils.isNotEmpty(xmmc)) {
            Xmk xmk = xmkMapper.selectOne(new LambdaQueryWrapper<Xmk>().eq(Xmk::getXmmc, xmmc.trim()));
            if (xmk != null) {
                xmhxResponse.setXmmc(xmk.getXmmc());
                xmhxResponse.setXmxq(xmk.getXmxq());
                xmhxResponse.setCyly(xmk.getCyly());
                xmhxResponse.setXmzt(xmk.getXmzt());
                xmhxResponse.setCyfx(xmk.getCyfx());
                xmhxResponse.setXmlx(xmk.getXmlx());
                List<Rck> rcks = rckMapper.selectList(new LambdaQueryWrapper<Rck>().eq(Rck::getYjly, xmk.getCyfx()));
                if (StringUtils.isNotEmpty(rcks)) {
                    List<String> tjrc = new ArrayList<>();
                    for (Rck rck : rcks) {
                        tjrc.add(rck.getPyxm().trim());
                    }
                    // TODO 这里需要去做出推荐人才，现在是直接打乱取前三个
                    Collections.shuffle(tjrc);
                    xmhxResponse.setTjrc(tjrc.size() > 3 ? tjrc.subList(0,3) : tjrc);
                }
                List<Cyjqcxpt> cyjqcxpts = cyjqcxptMapper.selectList(new LambdaQueryWrapper<Cyjqcxpt>().eq(Cyjqcxpt::getLy, xmk.getCyfx()));
                if (cyjqcxpts != null) {
                    List<String> tjkczy = new ArrayList<>();
                    for (Cyjqcxpt cyjqcxpt : cyjqcxpts) {
                        tjkczy.add(cyjqcxpt.getPtmc());
                    }
                    xmhxResponse.setTjkczy(tjkczy);
                }
            }
        }
        return xmhxResponse;
    }

    @Override
    public QyhxResponse qyhx(String qymc) {
        Qyk qyk = qykMapper.selectOne(new LambdaQueryWrapper<Qyk>().eq(Qyk::getQymc, qymc.trim()));
        QyhxResponse response = new QyhxResponse();
        response.setQymc(qyk.getQymc());
        if (StringUtils.isNotEmpty(qyk.getQylx())) {
            response.setQybq(Arrays.asList(qyk.getQylx().split("、")));
        }
        response.setSshy(qyk.getSshy());
        response.setCplb(qyk.getCplb());
        response.setLjjsrc(qyk.getLjjsrc());
        response.setHxjs(transHxjs2List(qyk.getHxjs()));
        List<Rck> rcks = rckMapper.selectList(new LambdaQueryWrapper<Rck>().eq(Rck::getPpgs, qyk.getQymc()));
        if (StringUtils.isNotEmpty(rcks)) {
            List<String> tjrc = new ArrayList<>();
            for (Rck rck : rcks) {
                tjrc.add(rck.getPyxm().trim());
            }
            response.setTjrc(tjrc.size()>3? tjrc.subList(0,3) : tjrc);
        }
        return response;
    }

    @Override
    public KcptResponse kcpt(String kcpt) {
        KcptResponse response = new KcptResponse();

        Cyjqcxpt cyjqcxpt = cyjqcxptMapper.selectOne(new LambdaQueryWrapper<Cyjqcxpt>().eq(Cyjqcxpt::getPtmc, kcpt.trim()));
        if (cyjqcxpt != null) {
            response.setPtmc(cyjqcxpt.getPtmc());
            response.setYtjg(cyjqcxpt.getYtjg());
            response.setLx(cyjqcxpt.getLx());
            response.setLy(cyjqcxpt.getLy());
            response.setHxjs(cyjqcxpt.getHxjs());
            List<Rck> rcks = rckMapper.selectList(new LambdaQueryWrapper<Rck>().eq(Rck::getYjly, cyjqcxpt.getLy()));
            if (StringUtils.isNotEmpty(rcks)) {
                List<String> tjrc = new ArrayList<>();
                for (Rck rck : rcks) {
                    tjrc.add(rck.getPyxm().trim());
                }
                // TODO 这里需要去做出推荐人才，现在是直接打乱取前三个
                Collections.shuffle(tjrc);
                response.setTjrc(tjrc.size()>3? tjrc.subList(0,3) : tjrc);
            }
        }
        return response;
    }

    private List<String> transHxjs2List(String hxjs) {
        String[] items = hxjs.split("\n");

        List<String> result = new ArrayList<>();

        for (String item : items) {
            // 使用正则表达式去除序号和末尾的"|"
            String cleanedItem = item.replaceAll("^\\d+\\.(.*)\\|$", "$1");
            result.add(cleanedItem);
        }
        return result;
    }
}
