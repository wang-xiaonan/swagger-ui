package com.swagger.swaggerui.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import io.swagger.annotations.ApiOperation;
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
 * 可以将bean注解到xml中，这样方便在正式环境中去掉Swagger <br>
 * 也可以配置Docket.enable属性
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket apiOne() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("one")
                .apiInfo(apiOneInfo())
                .enable(true) // 控制是否可用
                .select()
                .paths(apiOnePaths())
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))// 匹配给定注解的api
                .build();
    }

    private Predicate<String> apiOnePaths() {
        return Predicates.or(PathSelectors.regex("/api.*"));
    }

    private ApiInfo apiOneInfo() {
        return new ApiInfoBuilder()
                .title("TestSwaggerUI")
                .description("TestApiDocs")
                .termsOfServiceUrl("www.wangxiaonan.cn")
                .contact(new Contact("wxn", "https://github.com/wang-xiaonan/swagger-ui", "wangxiaonan_0553@163.com"))
                .version("1.0")
                .build();
    }

    @Bean
    public Docket apiTwo() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("two")
                .apiInfo(apiTwoInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(apiTwoPaths())
                .build();
    }

    private Predicate<String> apiTwoPaths() {
        return Predicates.or(PathSelectors.regex("/wxn.*"));// 根据url分组
    }

    private ApiInfo apiTwoInfo() {
        return new ApiInfoBuilder()
                .title("Swagger接口测试")
                .description("12345上山打老虎")
                .termsOfServiceUrl("www.wangxiaonan.cn")
                .contact(new Contact("wangxiaonan", "https://github.com/wang-xiaonan", "wangxiaonan_0553@163.com"))
                .version("1.0")
                .build();
    }
}
