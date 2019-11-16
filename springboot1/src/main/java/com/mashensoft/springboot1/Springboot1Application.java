package com.mashensoft.springboot1;

import com.mashensoft.springboot1.interceptor.HandlerInterceptorDemo;
import com.mashensoft.springboot1.interceptor.WebRequestInterceptorDemo;
import com.mashensoft.springboot1.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAspectJAutoProxy
@SpringBootApplication
public class Springboot1Application implements  ApplicationListener<ContextRefreshedEvent>, WebMvcConfigurer {
    static ApplicationContext ac;

    /**
     * 所有东西写在一个方法里。
     *
     * @return
     */
    @RequestMapping("/hello")
    public List<User> hello() {
        List<User> list = new ArrayList();
        list.add(new User("mashensoft", "123", 5));
        list.add(new User("xingge", "123", 17));
        return list;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        SpringApplication.run(Springboot1Application.class, args);
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ac = contextRefreshedEvent.getApplicationContext();
//        ac.getBean("")
    }

    /**
     * 实现WebMvcConfigurer接口，实现addInterceptors，把拦截器加入到
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //1：手工创建一个拦截器对象，
        //2：指定拦截器拦截的位置
        //用户登录的拦截器，用户登录功能放过，不能拦截。token  header
        registry.addInterceptor(new HandlerInterceptorDemo()).addPathPatterns("/**").excludePathPatterns("/loginError");
        registry.addWebRequestInterceptor(new WebRequestInterceptorDemo()).addPathPatterns("/**");
    }

//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        servletContext.setInitParameter("spring.profiles.default")
//    }
}
