package com.dkfrog.jaxdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试全局统一标准返回{@link com.dkfrog.jaxcommon.response.advice.ResponseAdvice}
 * 测试全局统一Swagger配置{@link com.dkfrog.jaxcommon.config.SwaggerConfigure}
 *
 * @author ramos.bh.wu@mail.foxconn.com
 * @date 2020-01-15 17:04
 */
@Api(tags = "Demo模块")
@RestController
public class CommonController {

    /**
     * http://localhost:10000/swagger-ui.html
     * http://localhost:10000/getString
     * 测试全局统一标准返回{@link com.dkfrog.jaxcommon.response.advice.ResponseAdvice}
     * 结果：{"code":10000,"message":"成功","data":"Hello, World"}
     */
    @ApiOperation(value = "getString")
    @GetMapping("/getString")
    public String getString() {
        return "Hello, World";
    }

    /**
     * 测试全局统一标准返回{@link com.dkfrog.jaxcommon.response.advice.ResponseAdvice}
     * 结果：
     * {
     *   "code": 10000,
     *   "message": "成功",
     *   "data": {
     *     "username": "Ramos",
     *     "password": "123456"
     *   }
     * }
     */
    @ApiOperation(value = "getObject")
    @GetMapping("/getObject")
    public UserVO getObject() {
        return new UserVO("Ramos", "123456");
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private class UserVO{
        private String username;
        private String password;
    }
}
