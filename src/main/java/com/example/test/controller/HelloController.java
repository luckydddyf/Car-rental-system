package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2020-12-31 14:03
 */
@Controller
public class HelloController {

    @RequestMapping("/index")
    public String sayHello(){
        return "index";
    }

}
