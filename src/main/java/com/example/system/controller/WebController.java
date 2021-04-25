package com.example.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-25 17:57
 */
@Controller
@Slf4j
public class WebController {

    @RequestMapping(value = "/login")
    public String login(Model model){
        log.info("进入login");
        model.addAttribute("name","租车管理系统");
        return "login";
    }

    @RequestMapping(value = "/main")
    public String main(){
        log.info("进入main");
        return "main";
    }


}
