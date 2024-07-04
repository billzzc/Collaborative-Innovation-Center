package com.aiit.hexlab.web.controller.map;

import com.aiit.hexlab.common.core.domain.AjaxNewResult;
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

    @ApiOperation(value = "产业人才入库趋势")
    @GetMapping("cyrcrkqs")
    public AjaxNewResult cyrcrkqs() {
        return AjaxNewResult.success(xtcxService.cyrcrkqs());
    }

    @ApiOperation(value = "人才行业分布")
    @GetMapping("rchyfb")
    public AjaxNewResult rchyfb() {
        return AjaxNewResult.success(xtcxService.rchyfb());
    }

    @ApiOperation(value = "近3年企业服务态势")
    @GetMapping("fwts")
    public AjaxNewResult fwts() {
        return AjaxNewResult.success(xtcxService.fwts());
    }

    @ApiOperation(value = "需求分析")
    @GetMapping("xqfx")
    public AjaxNewResult xqfx() {
        return AjaxNewResult.success(xtcxService.xqfx());
    }

    @ApiOperation(value = "创新成果分析")
    @GetMapping("cxcgfx")
    public AjaxNewResult cxcgfx() {
        return AjaxNewResult.success(xtcxService.cxcgfx());
    }

}
