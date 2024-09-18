package com.aiit.hexlab.web.controller.map;

import com.aiit.hexlab.common.core.domain.AjaxNewResult;
import com.aiit.hexlab.system.domain.vo.response.xtcxdp.*;
import com.aiit.hexlab.system.service.IXtcxService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("xtcx")
public class XtcxController {

    @Resource
    private IXtcxService xtcxService;

    @ApiOperation(value = "工程师培育生态")
    @GetMapping("gcspyst")
    public AjaxNewResult<GcspystResponse> gcspyst() {
        return AjaxNewResult.success(xtcxService.gcspyst());
    }

    @ApiOperation(value = "多跨人才培养")
    @GetMapping("dkrcpy")
    public AjaxNewResult<DkrcpyResponse> dkrcpy() {
        return AjaxNewResult.success(xtcxService.dkrcpy());
    }

    @ApiOperation(value = "共享工程师")
    @GetMapping("gxgcs")
    public AjaxNewResult<GxgcsResponse> gxgcs() {
        return AjaxNewResult.success(xtcxService.gxgcs());
    }

    @ApiOperation(value = "工程师核心技术")
    @GetMapping("gcshxjs")
    public AjaxNewResult<GcshxjsResponse> gcshxjs() {
        return AjaxNewResult.success(xtcxService.gcshxjs());
    }

    @ApiOperation(value = "首页")
    @GetMapping("index")
    public AjaxNewResult<IndexResponse> index() {
        return AjaxNewResult.success(xtcxService.index());
    }

    @ApiOperation(value = "工程师服务赋能")
    @GetMapping("gcsfwfn")
    public AjaxNewResult<GcsfwfnResponse> gcsfwfn() {
        return AjaxNewResult.success(xtcxService.gcsfwfn());
    }

    @ApiOperation(value = "科创成果")
    @GetMapping("kccg")
    public AjaxNewResult<KccgResponse> kccg() {
        return AjaxNewResult.success(xtcxService.kccg());
    }

    @ApiOperation(value = "创新孵化")
    @GetMapping("cxfh")
    public AjaxNewResult<CxfhResponse> cxfh() {
        return AjaxNewResult.success(xtcxService.cxfh());
    }

}
