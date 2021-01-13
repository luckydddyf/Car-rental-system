package com.example.system.util;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.example.system.mapper")
@ComponentScan("com.example")
public class TestApplication {

    @RequestMapping("/")
    public String hello() {
        return "Hello world!";
    }

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}
