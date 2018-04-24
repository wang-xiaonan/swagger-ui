package com.swagger.swaggerui.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangxiaonan
 * @Date: 2018/4/24
 **/
@RestController
@RequestMapping(value = "/wxn")
@Api(value = "wxn", tags = "tag01")
public class WxnController {

    @RequestMapping(value = "/hello")
    @ApiOperation(value = "sayHello", notes = "hello", httpMethod = "GET")
    public String sayHello(){
        return "hello";
    }
}
