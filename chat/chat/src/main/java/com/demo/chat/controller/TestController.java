package com.demo.chat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/secured")
    public String secured(){
        return "secured";
    }

    @GetMapping("/test")
    public String unsecured(){
        return "unsecured";
    }
}
