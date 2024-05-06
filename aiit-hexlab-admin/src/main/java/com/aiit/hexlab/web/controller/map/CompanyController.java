package com.aiit.hexlab.web.controller.map;

import com.aiit.hexlab.common.core.domain.AjaxNewResult;
import com.aiit.hexlab.system.domain.vo.response.company.*;
import com.aiit.hexlab.system.domain.vo.response.index.PieResponse;
import com.aiit.hexlab.system.service.ICompanyService;
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
@RequestMapping("map/company")
public class CompanyController {

    @Resource
    private ICompanyService companyService;

    @ApiOperation(value = "企业概览")
    @GetMapping("qygl")
    public AjaxNewResult<List<PieResponse>> qygl(){
        List<PieResponse> list = companyService.qygl();
        return AjaxNewResult.success(list);
    }

    @ApiOperation(value = "重点企业")
    @GetMapping("zdqy")
    public AjaxNewResult<ZdqyResponse> zdqy(){
        ZdqyResponse response = companyService.zdqy();
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value = "企业布局图首页包括地图以及上面三个数据")
    @GetMapping
    public AjaxNewResult<CompanyIndexResponse> index(){
        CompanyIndexResponse response = companyService.index();
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value = "企业赋能")
    @GetMapping("qyfn")
    public AjaxNewResult<QyfnResponse> qyfn(){
        QyfnResponse response = companyService.qyfn();
        return AjaxNewResult.success(response);
    }

    @ApiOperation(value = "企业需求")
    @GetMapping("qyxq")
    public AjaxNewResult<List<QyxqResponse>> qyxq(){
        List<QyxqResponse> list = companyService.qyxq();
        return AjaxNewResult.success(list);
    }

    @ApiOperation(value = "需求画像")
    @GetMapping("xqhx")
    @ApiImplicitParam(name = "xqmc", value = "需求名称", required = true, dataType = "String", paramType = "query")
    public AjaxNewResult<XqhxResponse> xqhx(@RequestParam("xqmc") String xqmc){
        XqhxResponse response = companyService.xqhx(xqmc);
        return AjaxNewResult.success(response);
    }

    @GetMapping("location")
    public AjaxNewResult location(){
        companyService.updateLatAndLgt();
        return AjaxNewResult.success();
    }
}
