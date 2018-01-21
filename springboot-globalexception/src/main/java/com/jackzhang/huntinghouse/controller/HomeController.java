package com.jackzhang.huntinghouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jack
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("name","嘿嘿嘿");
        return "index";
    }
    @GetMapping("/403")
    public String accessError(){
        return "403";
    }
}
