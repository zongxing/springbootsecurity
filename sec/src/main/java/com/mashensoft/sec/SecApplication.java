package com.mashensoft.sec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SecApplication extends WebSecurityConfigurerAdapter {
    @RequestMapping("/user")
    public String user() {
        return "hello user";
    }

    @RequestMapping("/role")
    public String role() {
        return "hello role";
    }

    @RequestMapping("/user/menu")
    public String getuser() {
        return "user profile";
    }

    static Logger log = LoggerFactory.getLogger(SpringBootApplication.class);

    public static void main(String[] args) {
        log.info("this is mashensoft");
        SpringApplication.run(SecApplication.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/menu").permitAll().antMatchers("/user/**").hasRole("admin").and().formLogin();
        http.authorizeRequests().antMatchers("/role/**").hasRole("sys").and().formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("xingge").password(new BCryptPasswordEncoder().encode("123")).roles("admin");
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("zongxing").password(new BCryptPasswordEncoder().encode("666")).roles("sys");

    }
}
