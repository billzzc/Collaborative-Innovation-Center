package com.aiit.hexlab.web.controller.map;

import com.aiit.hexlab.common.core.domain.AjaxNewResult;
import com.aiit.hexlab.system.domain.vo.response.index.DtzbResponse;
import com.aiit.hexlab.system.domain.vo.response.index.IndexResponse;
import com.aiit.hexlab.system.domain.vo.response.index.QqhrzdrcResponse;
import com.aiit.hexlab.system.domain.vo.response.talents.*;
import com.aiit.hexlab.system.service.ITalentsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("map/talents")
public class TalentsController {

    @Resource
    private ITalentsService talentsService;

    @ApiOperation(value = "产业链概览", notes = "企业列表数据，上方的分类数据需要前端写死")
    @GetMapping("cylgl")
    @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<List<QyResponse>> cylgl(@RequestParam(value = "type") String type) {
        List<QyResponse> list = talentsService.cylgl(type);
        return AjaxNewResult.success(list);
    }

    @ApiOperation(value = "科创平台")
    @GetMapping("kcpt")
    public AjaxNewResult<List<KcptResponse>> kcpt() {
        List<KcptResponse> list = talentsService.kcpt();
        return AjaxNewResult.success(list);
    }

    @ApiOperation(value = "产业布局图首页包括地图以及上面三个数据")
    @GetMapping
    public AjaxNewResult<IndexResponse> dtzb() {
        IndexResponse response = talentsService.index();
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value = "技术关键词")
    @GetMapping("jsgjc")
    @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<List<JsgjcResponse>> jsgjc(@RequestParam("type") String type) {
        List<JsgjcResponse> list = talentsService.jsgjc(type);
        return AjaxNewResult.success(list);
    }

    @ApiOperation(value = "产业需求趋势分析")
    @GetMapping("cyxqqsfx")
    public AjaxNewResult<List<CyxqqsfxResponse>> cyxqqsfx() {
        List<CyxqqsfxResponse> response = talentsService.cyxqqsfx();
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value = "热点岗位预测")
    @GetMapping("rdgwyc")
    public AjaxNewResult<List<RdgwycResponse>> rdgwyc() {
        List<RdgwycResponse> response = talentsService.rdgwyc();
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value = "岗位画像")
    @GetMapping("gwhx")
    @ApiImplicitParam(name = "gwmc", value = "岗位名称", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<GwhxResponse> gwhx(@RequestParam("gwmc") String gwmc) {
        GwhxResponse gwhx = talentsService.gwhx(gwmc);
        return AjaxNewResult.success(gwhx);
    }
}
