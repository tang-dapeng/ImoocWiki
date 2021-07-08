package com.jiawa.wiki.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dapeng
 * @create 2021-07-08 00:13
 */
@RestController
public class TestController {
    @Value("${test.hello:TEST}")
    private String test;

    @GetMapping("/hello")
    public String helloworld(){
        return "Hello World!" + test;
    }

    @PostMapping("/hello/post")
    public String helloworld(String name){
        return "Hello World Post!" + name;
    }

}
