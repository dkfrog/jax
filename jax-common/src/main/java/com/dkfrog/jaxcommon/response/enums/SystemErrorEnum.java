package com.dkfrog.jaxcommon.response.enums;

import com.dkfrog.jaxcommon.response.IErrorInfo;

/**
 * 系统级别/通用异常枚举
 *
 * @author ramos.bh.wu@mail.foxconn.com
 * @date 2020-01-16 14:18
 * @since 1.0.1
 */
public enum SystemErrorEnum implements IErrorInfo {
    /**
     * 请求处理成功
     */
    SUCCESS(10000, "成功"),
    /**
     * 服务器内部异常
     */
    SYSTEM_ERROR(10001, "系统异常，请稍后重试"),
    /**
     * 非法参数
     */
    ILLEGAL_PARAMETER(10002, "非法参数"),;

    private int code;
    private String message;

    SystemErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
