package com.aiit.hexlab.framework.security.handle;

import com.aiit.hexlab.common.constant.Constants;
import com.aiit.hexlab.common.core.domain.AjaxResult;
import com.aiit.hexlab.common.core.domain.model.LoginUser;
import com.aiit.hexlab.common.utils.MessageUtils;
import com.aiit.hexlab.common.utils.ServletUtils;
import com.aiit.hexlab.common.utils.StringUtils;
import com.aiit.hexlab.framework.manager.AsyncManager;
import com.aiit.hexlab.framework.manager.factory.AsyncFactory;
import com.aiit.hexlab.framework.web.service.TokenService;
import com.alibaba.fastjson2.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义退出处理类 返回成功
 * 
 * @author Zkoi
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler
{
    @Autowired
    private TokenService tokenService;

    /**
     * 退出处理
     * 
     * @return
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException
    {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser))
        {
            String username = loginUser.getUsername();
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
            // 记录用户退出日志
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGOUT, MessageUtils.message("user.logout.success")));
        }
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.success(MessageUtils.message("user.logout.success"))));
    }
}
