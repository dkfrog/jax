package com.dkfrog.jaxcommon.response.exceptions;

import com.dkfrog.jaxcommon.response.IErrorInfo;

/**
 * 自定义业务异常
 *
 * @author ramos.bh.wu@mail.foxconn.com
 * @date 2020-01-16 14:21
 * @since 1.0.1
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 4367229628497273973L;
    private Integer code;
    private String message;

    public BusinessException(IErrorInfo errorInfo) {
        this.code = errorInfo.getCode();
        this.message = errorInfo.getMessage();
    }

    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
