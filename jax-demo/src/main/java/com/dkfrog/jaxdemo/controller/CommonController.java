package com.dkfrog.jaxdemo.controller;

import com.dkfrog.jaxcommon.response.ResultDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ramos.bh.wu@mail.foxconn.com
 * @date 2020-01-15 17:04
 */
@RestController
public class CommonController {

    /**
     * http://localhost:10000/getString
     */
    @GetMapping("/getString")
    public ResultDTO getString() {
        return ResultDTO.success("data");
    }

    @GetMapping("/getObject")
    public String getObject() {
        return "{\n" +
                "  \"username\": \"Ramos\",\n" +
                "  \"password\": \"123456\"\n" +
                "}";
    }
}
