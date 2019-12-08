package com.nyist_shop.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


@Configuration
//开启swagger2的自动配置
@EnableSwagger2
public class SwaggerConfig {
    // 配置docket以配置Swagger具体参数
    @Bean
    public Docket docket(Environment environment) {
        //获取环境 生产环境 测试环境，以及发布环境通过判断
        boolean flag = environment.acceptsProfiles(Profiles.of("dev", "text"));
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //配置多个分组
                .groupName("焦洋")
                //  .enable(false)是否启用swagger false不能，true可以
                .enable(flag)
                .select()
                //RequestHandlerSelectors:指定要扫描的接口方式
                //basePackage()：指定要扫描的包
                //any():扫描全部
                //none():不扫描
                //withClassAnnotation：扫描类上的注解
                //withMethodAnnotation：扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.nyist_shop.user.controller"))
                //paths()过滤路径 只扫描该路径下
                .paths(PathSelectors.ant("/user/**"))
                .build();
    }

    //配置swagger 信息=apiInfo
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("焦洋", "https://localhost:8080", "838855804@qq.com");
        return new ApiInfo("nyist-shop Api文档", // 标题
                "展示本项目全部api接口", // 描述
                "v1.0.0", // 版本
                "https://localhost:8080", // 组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()); // 扩展
    }

}
