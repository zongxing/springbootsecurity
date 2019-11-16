package com.mashensoft.springboot1.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class MyObject {
    //    @Value("mashensoft")
//    @Value("${companyname}")
//@Value("#{systemProperties['user.home']}")
//@Value("#{ T(java.lang.Math).random() * 100.0 }")
    @Value("#{ userService.username }")
    private String companyName;
    @Value("http://www.mashensoft.com")
    private Resource resource;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
