package com.kubrafelek.homework04.config;

import com.kubrafelek.homework04.util.ClientRequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    ClientRequestInfo clientRequestInfo;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        clientRequestInfo.setClientIpAddress(request.getRemoteAddr());
        clientRequestInfo.setClientUrl(request.getRequestURI());
        clientRequestInfo.setSessionActivityId(request.getSession().getId());
        return true;
    }
}
