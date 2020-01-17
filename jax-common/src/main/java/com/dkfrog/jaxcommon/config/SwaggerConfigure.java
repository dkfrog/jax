package com.dkfrog.jaxcommon.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置
 *
 * @author ramos.bh.wu@mail.foxconn.com
 * @date 2020-01-17 14:19
 * @since 0.0.1
 */
@Configuration
@EnableSwagger2
public class SwaggerConfigure {
    @Bean
    public Docket customDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 是否开启Swagger2
                .enable(true)
                .select()
                // 扫描的路径包,设置basePackage会将包下的所有被@Api标记类的所有方法作为api
                //.apis(RequestHandlerSelectors.basePackage("com.st.fileservice.controller"))
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                // 指定路径处理，PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                // 设置文档标题
                .title("贾克斯--一个SpringBoot框架整合系统")
                // 文档描述
                .description("包括各种整合测试API")
                // 版本号
                .version("V0.0.1")
                // 联系信息， name: 开发者， url：项目地址， email：邮箱
                .contact(new Contact("迪卡蛙", "https://github.com/dkfrog/jax", "ramos_javax@163.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}
