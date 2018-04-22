package com.swagger.swaggerui.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置Swagger自动生成apiDocs <br/>
 * 常用的Swagger注解 http://docs.swagger.io/swagger-core/apidocs/index.html,
 *                 https://github.com/swagger-api/swagger-core/wiki/Annotations <br/>
 */
@RestController
@RequestMapping("/api")
@Api(value = "api接口文档", description = "api根目录")
public class ApiController {
    /*
    - @Api()用于类名
    - @ApiOperation()用于方法名
    - @ApiParam()用于参数说明
    - @ApiModel()用于实体类
    - @ApiModelProperty用于实体类属性
     */
    @RequestMapping(value = "/test")
    @ApiOperation(value = "测试", notes = "测试返回222", httpMethod = "GET")
    @ApiImplicitParams({})
    public String test(){
        return "222";
    }

}
