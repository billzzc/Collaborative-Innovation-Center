package com.aiit.hexlab.web.controller.map;

import com.aiit.hexlab.common.core.domain.AjaxNewResult;
import com.aiit.hexlab.common.core.domain.AjaxResult;
import com.aiit.hexlab.system.domain.vo.response.*;
import com.aiit.hexlab.system.service.IMapService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("map")
public class MapController {

    @Resource
    private IMapService mapService;

    @ApiOperation(value = "产业企业概览")
    @GetMapping("cyqygl")
    @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<List<PieResponse>> qygl(@RequestParam("type") String type) {
        return AjaxNewResult.success(mapService.cyqygl(type));
    }

    @ApiOperation(value = "产业核心技术")
    @GetMapping("cyhxjs")
    @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<CyhxjsResponse> cyhxjs(@RequestParam("type") String type) {
        return AjaxNewResult.success(mapService.cyhxjs(type));
    }

    @ApiOperation(value = "产业企业")
    @GetMapping("cyqy")
    @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<CyqyResponse> cyqy(@RequestParam("type") String type) {
        return AjaxNewResult.success(mapService.cyqy(type));
    }

    @ApiOperation(value = "地图")
    @GetMapping("index")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "名称", required = false, dataType = "String", paramType = "query")
    })
    public AjaxNewResult<IndexResponse> index(@RequestParam("type") String type, @RequestParam(value = "name", required = false) String name) {
        return AjaxNewResult.success(mapService.index(type, name));
    }

    @ApiOperation(value = "产业现有人才")
    @GetMapping("cyxyrc")
    @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<List<CyxyrcResponse>> cyxyrc(@RequestParam("type") String type) {
        List<CyxyrcResponse> list = mapService.cyxyrc(type);
        return AjaxNewResult.success(list);
    }

    @ApiOperation(value = "产业人才库分析")
    @GetMapping("cyrck")
    @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<CydyrcResponse> cyrck(@RequestParam("type") String type) {
        return AjaxNewResult.success(mapService.cyrck(type));
    }

    @ApiOperation(value = "产业园区")
    @GetMapping("cyyq")
    @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<List<CyyqResponse>> cyyq(@RequestParam("type") String type) {
        List<CyyqResponse> list = mapService.cyyq(type);
        return AjaxNewResult.success(list);
    }

    @ApiOperation(value = "科创平台")
    @GetMapping("kcpt")
    @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<List<KcptResponse>> kcpt(@RequestParam("type") String type) {
        List<KcptResponse> list = mapService.kcpt(type);
        return AjaxNewResult.success(list);
    }

    @ApiOperation(value ="盯引人才画像")
    @GetMapping("dyrchx")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Long", paramType = "query")
    public AjaxNewResult<DyrchxResponse> rchx(@RequestParam("id") Long id, @RequestParam("type") String type) {
        DyrchxResponse response = mapService.rchx(id, type);
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value ="企业画像")
    @GetMapping("qyhx")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Long", paramType = "query")
    public AjaxNewResult<QyhxResponse> qyhx(@RequestParam("id") Long id) {
        QyhxResponse response = mapService.qyhx(id);
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value ="人才画像（现存）")
    @GetMapping("rckrchx")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Long", paramType = "query")
    public AjaxNewResult<ZkrchxResponse> rckrchx(@RequestParam("id") Long id, @RequestParam("type") String type) {
        ZkrchxResponse response = mapService.rckrchx(id, type);
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value ="产业园区画像")
    @GetMapping("cyyqhx")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Long", paramType = "query")
    public AjaxNewResult<CyyqhxResponse> cyyqhx(@RequestParam("id") Long id) {
        CyyqhxResponse response = mapService.cyyqhx(id);
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value ="科创平台画像")
    @GetMapping("kcpthx")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Long", paramType = "query")
    public AjaxNewResult<KcpthxResponse> kcpthx(@RequestParam("id") Long id) {
        KcpthxResponse response = mapService.kcpthx(id);
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value ="产业盯引人才库")
    @GetMapping("cydyrck")
    @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<List<CydyrckResponse>> cydyrck(@RequestParam("type") String type) {
        List<CydyrckResponse> list = mapService.cydyrck(type);
        return AjaxNewResult.success(list);
    }

    @ApiOperation(value ="盯引人才来源")
    @GetMapping("dyrcly")
    @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<List<DyrclyResponse>> dyrcly(@RequestParam("type") String type) {
        List<DyrclyResponse> list = mapService.dyrcly(type);
        return AjaxNewResult.success(list);
    }

    @ApiOperation(value = "更新经纬度")
    @GetMapping("location")
    public AjaxResult location(@RequestParam("type") String type) {
        mapService.location(type);
        return AjaxResult.success();
    }

}
