package com.dkfrog.jaxcommon.response;

/**
 * @author ramos.bh.wu@mail.foxconn.com
 * @date 2020-01-16 14:13
 * @since 1.0.1
 */
public interface IErrorInfo {
    /**
     * 获取状态码
     */
    int getCode();

    /**
     * 获取状态描述
     */
    String getMessage();
}
