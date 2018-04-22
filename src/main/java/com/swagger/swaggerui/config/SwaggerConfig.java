package com.swagger.swaggerui.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 可以将bean注解到xml中，这样方便在正式环境中去掉Swagger <br>
 * 也可以配置Docket.enable属性
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket testApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true) // 控制是否可用
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))// 匹配给定注解的api
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("TestSwaggerUI")
                .description("TestApiDocs")
                .termsOfServiceUrl("www.wangxiaonan.cn")
                .contact(new Contact("wxn","","wangxiaonan_0553@163.com"))
                .version("1.0")
                .build();
    }
}
