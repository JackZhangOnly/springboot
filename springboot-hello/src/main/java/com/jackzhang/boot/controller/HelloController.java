package com.jackzhang.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jack
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello,there";
    }
}
