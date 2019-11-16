package com.mashensoft.springboot1.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionAdvise {
    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> errorHandler(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 100);
        System.out.println(e.getMessage());
        e.fillInStackTrace();
        map.put("msg", e.getLocalizedMessage());
        return map;
    }

}
