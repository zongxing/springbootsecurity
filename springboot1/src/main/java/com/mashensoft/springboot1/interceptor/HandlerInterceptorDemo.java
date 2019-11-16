package com.mashensoft.springboot1.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

public class HandlerInterceptorDemo implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //request.getRequestDispatcher("/loginError").forward(request,response);
        String token = request.getHeader("token");
        if (token == null) {
            //
        }
        System.out.println(request.getRequestURI());
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String key = enu.nextElement();
            String value = request.getParameter(key);
            System.out.println(key + "=" + value);
        }
        Map map = request.getParameterMap();
        Set set = map.keySet();
        set.forEach(key -> {
            String[] value = (String[]) map.get(key);
            //System.out.println("key:"+key+"="+value[0]);
        });
        request.getParameterValues("");
        request.getParameterNames();
        System.out.println("拦截器1号，开始前");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器1号，请求后");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器1号，最终完成");
    }
}
