package com.example.system;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-14 9:47
 */
@SpringBootApplication
@RestController
@Slf4j
@MapperScan("com.example.system.mapper")
@ComponentScan("com.example")
public class SystemApplication {

    @RequestMapping(value = "/")
    public String hello() {
        return "hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }

}
