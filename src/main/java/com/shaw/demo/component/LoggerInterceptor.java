package com.shaw.demo.component;

import com.shaw.demo.model.SystemLog;
import com.shaw.demo.model.SystemView;
import com.shaw.demo.service.SystemLogService;
import com.shaw.demo.service.SystemViewService;
import com.shaw.demo.util.BrowserUtil;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoggerInterceptor implements HandlerInterceptor {

    @Autowired
    private SystemLogService systemLogService;

    @Autowired
    private SystemViewService systemViewService;

    SystemView view = new SystemView();

    SystemLog log = new SystemLog();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String ipAddress = request.getRemoteAddr();
        String url = request.getRequestURL().toString();
        String toolDetail = BrowserUtil.getBrowserInfo(request);

        log.setIpAddress(StringUtils.isEmpty(ipAddress) ? "0.0.0.0" : ipAddress);
        log.setOperateURL(StringUtils.isEmpty(url) ? "Capture Failed" : url);
        log.setOperateBy(StringUtils.isEmpty(toolDetail) ? "Capture Failed" : toolDetail);

        view.setIpAddress(StringUtils.isEmpty(ipAddress) ? "0.0.0.0" : ipAddress);
        systemViewService.addView(view);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                            @Nullable ModelAndView modelAndView) throws Exception {
        systemLogService.createLog(log);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {
    }
}
