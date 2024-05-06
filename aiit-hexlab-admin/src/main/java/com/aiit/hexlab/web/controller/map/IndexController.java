package com.aiit.hexlab.web.controller.map;

import com.aiit.hexlab.common.core.domain.AjaxNewResult;
import com.aiit.hexlab.system.domain.vo.response.index.*;
import com.aiit.hexlab.system.service.IIndexService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("map/index")
public class IndexController{

    @Resource
    private IIndexService indexService;

    @ApiOperation(value ="产业人才需求")
    @GetMapping("cyrcxq")
    public AjaxNewResult<List<CyrcxqResponse>> cyrcxq(){
        List<CyrcxqResponse> list = indexService.cyrcxq();
        return AjaxNewResult.success(list);
    }

    @ApiOperation(value = "产业急缺岗位")
    @GetMapping("cyjqgw")
    public AjaxNewResult<List<CyjqgwResponse>> cyjqgw(){
        List<CyjqgwResponse> list = indexService.cyjqgw();
        return AjaxNewResult.success(list);
    }

    @ApiOperation(value = "重大项目表")
    @GetMapping("zdxm")
    public AjaxNewResult<ZdxmResponse> zdxm(){
        ZdxmResponse zdxmResponse = indexService.zdxm();
        return AjaxNewResult.success(zdxmResponse);
    }

    @ApiOperation(value = "首页地图包括地图以及上面三个数据")
    @GetMapping
    public AjaxNewResult<IndexResponse> maps(){
        IndexResponse indexResponse = indexService.index();
        return AjaxNewResult.success(indexResponse);
    }

    @ApiOperation(value = "全球华人重点人才")
    @GetMapping("qqhrzdrc")
    public AjaxNewResult<List<QqhrzdrcResponse>> qqhrzdrc(){
        List<QqhrzdrcResponse> list = indexService.qqhrzdrc();
        return AjaxNewResult.success(list);
    }

    @ApiOperation(value = "本地产业人才分析")
    @GetMapping("bdcyrcfx")
    public AjaxNewResult<BdcyrcfxResponse> bdcyrcfx(){
        BdcyrcfxResponse bdcyrcfxResponse = indexService.bdcyrcfx();
        return AjaxNewResult.success(bdcyrcfxResponse);
    }

    @ApiOperation(value = "细分领域人才分析")
    @GetMapping("xflyrcfx")
    public AjaxNewResult<List<XflyrcfxResponse>> xflyrcfx(){
        List<XflyrcfxResponse> xflyrcfxResponse = indexService.xflyrcfx();
        return AjaxNewResult.success(xflyrcfxResponse);
    }

    @ApiOperation(value = "人才画像")
    @GetMapping("rchx")
    @ApiImplicitParam(name = "rcxm", value = "人才姓名", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<RchxResponse> rchx(@RequestParam("rcxm") String rcxm){
        RchxResponse rchxResponse = indexService.rchx(rcxm);
        return AjaxNewResult.success(rchxResponse);
    }

    @ApiOperation(value = "企业画像")
    @GetMapping("qyhx")
    @ApiImplicitParam(name = "qymc", value = "企业名称", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<QyhxResponse> qyhx(@RequestParam("qymc") String qymc){
        QyhxResponse qyhxResponse = indexService.qyhx(qymc);
        return AjaxNewResult.success(qyhxResponse);
    }

    @ApiOperation(value = "科创平台")
    @GetMapping("kcpt")
    @ApiImplicitParam(name = "ptmc", value = "平台名称", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<KcptResponse> kcpt(@RequestParam("ptmc") String ptmc){
        KcptResponse kcptResponse = indexService.kcpt(ptmc);
        return AjaxNewResult.success(kcptResponse);
    }

    @ApiOperation(value = "项目画像")
    @GetMapping("xmhx")
    @ApiImplicitParam(name = "xmmc", value = "项目名称", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<XmhxResponse> xmhx(@RequestParam("xmmc") String xmmc){
        XmhxResponse xmhxResponse = indexService.xmhx(xmmc);
        return AjaxNewResult.success(xmhxResponse);
    }

}
