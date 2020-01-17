package com.dkfrog.jaxcommon.response.advice;

import com.dkfrog.jaxcommon.response.ResultDTO;
import com.dkfrog.jaxcommon.response.exceptions.BusinessException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author ramos.bh.wu@mail.foxconn.com
 * @date 2020-01-16 14:31
 * @since 1.0.1
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(BusinessException.class)
    public ResultDTO<String> businessExceptionHandler() {
        return new ResultDTO<>();
    }

    @ExceptionHandler(BindException.class)
    public ResultDTO<String> bindExceptionHandler(BindException exception) {
        return new ResultDTO<>();
    }
}
