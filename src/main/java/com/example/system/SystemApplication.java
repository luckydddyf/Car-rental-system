package com.example.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 解决跨域问题
 * @Author luckydddyf
 * @Date 2021-01-14 9:47
 */
@SpringBootApplication
@RestController
@MapperScan("com.example.system.mapper")
@ComponentScan("com.example")
public class SystemApplication {

    @RequestMapping("/")
    public String hello() {
        return "Hello world!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }

}
