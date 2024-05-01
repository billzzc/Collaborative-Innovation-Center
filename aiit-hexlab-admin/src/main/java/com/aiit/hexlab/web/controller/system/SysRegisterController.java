package com.aiit.hexlab.web.controller.system;

import com.aiit.hexlab.common.core.controller.BaseController;
import com.aiit.hexlab.common.core.domain.AjaxResult;
import com.aiit.hexlab.common.core.domain.model.RegisterBody;
import com.aiit.hexlab.common.utils.StringUtils;
import com.aiit.hexlab.framework.web.service.SysRegisterService;
import com.aiit.hexlab.system.service.IPatientInfoService;
import com.aiit.hexlab.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册验证
 * 
 * @author Zkoi
 */
@RestController
public class SysRegisterController extends BaseController
{
    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private IPatientInfoService patientInfoService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user)
    {
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser"))))
        {
            return error("当前系统没有开启注册功能！");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }

    @PostMapping("/patientRegister")
    public AjaxResult patientRegister(@RequestBody RegisterBody user)
    {
        String msg = patientInfoService.patientRegister(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}
