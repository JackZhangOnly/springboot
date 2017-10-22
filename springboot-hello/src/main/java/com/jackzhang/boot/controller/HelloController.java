package com.jackzhang.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jack on 2017/10/22.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello,there";
    }
}
