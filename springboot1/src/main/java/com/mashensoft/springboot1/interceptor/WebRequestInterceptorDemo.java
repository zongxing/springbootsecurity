package com.mashensoft.springboot1.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class WebRequestInterceptorDemo implements WebRequestInterceptor {
    @Override
    public void preHandle(WebRequest webRequest) throws Exception {
        System.out.println("拦截器2号，开始前");
    }

    @Override
    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {
        System.out.println("拦截器2号，开始后");
    }

    @Override
    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {
        System.out.println("拦截器2号，结束");
    }
}
