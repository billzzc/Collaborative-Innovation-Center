package com.aiit.hexlab.web.controller.map;

import com.aiit.hexlab.common.core.domain.AjaxNewResult;
import com.aiit.hexlab.system.domain.vo.response.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("map")
public class MapController {

    @ApiOperation(value = "产业企业概览")
    @GetMapping("cyqygl")
    @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<List<PieResponse>> qygl(@RequestParam("type") String type) {
        List<PieResponse> list = new ArrayList<>();
        return AjaxNewResult.success(list);
    }

    @ApiOperation(value = "产业核心技术")
    @GetMapping("cyhxjs")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "名称", required = true, dataType = "String", paramType = "query")
    })
    public AjaxNewResult<CyhxjsResponse> cyhxjs(@RequestParam("type") String type, @RequestParam("name") String name) {
        CyhxjsResponse response = new CyhxjsResponse();
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value = "产业企业")
    @GetMapping("cyqy")
    @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<CyqyResponse> cyqy(@RequestParam("type") String type) {
        CyqyResponse response = new CyqyResponse();
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value = "地图")
    @GetMapping("index")
    @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<MapResponse> index(@RequestParam("type") String type) {
        MapResponse response = new MapResponse();
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value = "产业现有人才")
    @GetMapping("cyxyrc")
    @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<List<CyxyrcResponse>> cyxyrc(@RequestParam("type") String type) {
        List<CyxyrcResponse> list = new ArrayList<>();
        return AjaxNewResult.success(list);
    }

    @ApiOperation(value = "产业盯引人才")
    @GetMapping("cydyrc")
    @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<CydyrcResponse> cydyrc(@RequestParam("type") String type) {
        CydyrcResponse response = new CydyrcResponse();
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value = "产业园区")
    @GetMapping("cyyq")
    @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<List<CyyqResponse>> cyqyq(@RequestParam("type") String type) {
        List<CyyqResponse> list = new ArrayList<>();
        return AjaxNewResult.success(list);
    }

    @ApiOperation(value = "科创平台")
    @GetMapping("kcpt")
    @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<List<KcptResponse>> kcpt(@RequestParam("type") String type) {
        List<KcptResponse> list = new ArrayList<>();
        return AjaxNewResult.success(list);
    }

    @ApiOperation(value ="盯引人才画像")
    @GetMapping("dyrchx")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Long", paramType = "query")
    public AjaxNewResult<DyrchxResponse> rchx(@RequestParam("id") Long id) {
        DyrchxResponse response = new DyrchxResponse();
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value ="企业画像")
    @GetMapping("qyhx")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Long", paramType = "query")
    public AjaxNewResult<QyhxResponse> qyhx(@RequestParam("id") Long id) {
        QyhxResponse response = new QyhxResponse();
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value ="人才画像（现存）")
    @GetMapping("rckrchx")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Long", paramType = "query")
    public AjaxNewResult<ZkrchxResponse> rckrchx(@RequestParam("id") Long id) {
        ZkrchxResponse response = new ZkrchxResponse();
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value ="产业园区画像")
    @GetMapping("cyyqhx")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Long", paramType = "query")
    public AjaxNewResult<CyyqhxResponse> cyyqhx(@RequestParam("id") Long id) {
        CyyqhxResponse response = new CyyqhxResponse();
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value ="科创平台画像")
    @GetMapping("kcpthx")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Long", paramType = "query")
    public AjaxNewResult<KcpthxResponse> kcpthx(@RequestParam("id") Long id) {
        KcpthxResponse response = new KcpthxResponse();
        return AjaxNewResult.success(response);
    }

}
