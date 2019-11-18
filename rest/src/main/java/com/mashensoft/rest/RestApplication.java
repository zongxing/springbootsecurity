package com.mashensoft.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class RestApplication {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping("/user")
    public List<User> userList(){
        return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
    }
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

}
