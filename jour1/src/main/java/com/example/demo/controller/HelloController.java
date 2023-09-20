package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource("classpath:application.yml")
public class HelloController {

    @Value("${profiles.${profiles.active}.message}")
    String msg;

    @GetMapping("/")
    public String hello() { return msg; }
}
