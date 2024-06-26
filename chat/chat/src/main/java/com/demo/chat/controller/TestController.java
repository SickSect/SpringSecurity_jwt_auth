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

    @GetMapping("/reader")
    public String reader(){
        return "reader";
    }

    @GetMapping("/editor")
    public String editor(){
        return "editor";
    }

    @GetMapping("/author")
    public String author(){
        return "author";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
}
