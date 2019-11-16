package com.mashensoft.springboot1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @RequestMapping("/loginError")
    public Map<String, Object> loginError() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "400");
        map.put("msg", "not login");
        return map;
    }
}
