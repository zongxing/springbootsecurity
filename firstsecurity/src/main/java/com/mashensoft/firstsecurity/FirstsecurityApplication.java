package com.mashensoft.firstsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FirstsecurityApplication extends WebSecurityConfigurerAdapter {
    /**
     * 1：用户管理员：看到user
     */
    @RequestMapping("/user")
    public String user(){
        return "hello user";
    }
    /**
     * 1：产品管理员：可以看到product
     */
    @RequestMapping("/product")
    public String product(){
        return "hello product";
    }
    @RequestMapping("/mylogin")
    public String login(){
        return "login";
    }
    public static void main(String[] args) {
        SpringApplication.run(FirstsecurityApplication.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/user/**").hasRole("userAdmin").and().formLogin();
        http.authorizeRequests().antMatchers("/product/**").hasRole("productAdmin").and().formLogin();
        http.authorizeRequests().antMatchers("/mylogin/**").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("xingge").password(new BCryptPasswordEncoder().encode("123")).roles("userAdmin");
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("zongxing").password(new BCryptPasswordEncoder().encode("666")).roles("productAdmin","userAdmin");
    }
}
