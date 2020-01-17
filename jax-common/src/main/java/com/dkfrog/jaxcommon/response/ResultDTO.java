package com.dkfrog.jaxcommon.response;

import com.dkfrog.jaxcommon.response.enums.SystemErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Map;

/**
 * 接口标准返回实体类
 *
 * @author ramos.bh.wu@mail.foxconn.com
 * @date 2020-01-15 16:57
 * @since 1.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO<T> {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 状态描述
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    public ResultDTO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultDTO(IErrorInfo errorInfo) {
        this.code = errorInfo.getCode();
        this.message = errorInfo.getMessage();
    }

    public ResultDTO(IErrorInfo errorInfo, T data) {
        this.code = errorInfo.getCode();
        this.message = errorInfo.getMessage();
        this.data = data;
    }

    public static ResultDTO success() {
        return new ResultDTO<>(SystemErrorEnum.SUCCESS, Collections.emptyMap());
    }

    /**
     * 成功并返回数据
     */
    public static <T> ResultDTO success(T data) {
        return new ResultDTO<>(SystemErrorEnum.SUCCESS, data);
    }

    public static ResultDTO fail(IErrorInfo errorInfo) {
        return new ResultDTO<Map>(errorInfo, Collections.emptyMap());
    }
}
