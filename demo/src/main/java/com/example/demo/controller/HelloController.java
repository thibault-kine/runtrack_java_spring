package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource("classpath:application.yml")
public class HelloController {
    @Value("${spring.profiles.active}")
    String activeProfile;

    @Value("${spring.profiles.dev.message}")
    String devMsg;

    @Value("${spring.profiles.prod.message}")
    String prodMsg;

    @GetMapping("/")
    public String hello() {
        if("dev".equals(activeProfile)) {
            return devMsg;
        }
        else {
            return prodMsg;
        }
    }
}
