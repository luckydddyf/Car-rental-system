package com.example.system.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description
 * @Author luckydddyf
 * @Date 2021-01-08 14:46
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.example.system.controller";
    public static final String VERSION = "1.0.0";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("租车管理系统")
                .description("租车管理系统 API 接口文档")
                .version(VERSION)
                .termsOfServiceUrl("http://localhost:8081/system/swagger-ui.html")
                .build();
    }

}
