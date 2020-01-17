package com.dkfrog.jaxcommon.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * JSON解析工具类
 *
 * @author ramos
 * @version 1.0
 * @create 2018-04-25 16:49
 */
public class JsonUtils {

    private static ObjectMapper objectMapper;

    static {
            objectMapper = new ObjectMapper();
    }

    public static String beanToString(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    /**
     * 对象转JSON字符串,解析异常时返回预设值
     */
    public static String beanToString(Object value, String defaultValue) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            return defaultValue;
        }
    }

    /**
     * JSON字符串转对象
     */
    public static <T> T stringToBean(String json, Class<T> cls) {
        try {
            return objectMapper.readValue(json, cls);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * 字符串转list对象
     */
    public static <T> List<T> stringTolist(String jsonStr, Class<T> cls) {
        ObjectMapper mapper = new ObjectMapper();
        List<T> objList;
        try {
            JavaType t = mapper.getTypeFactory().constructParametricType(
                    List.class, cls);
            objList = mapper.readValue(jsonStr, t);
        } catch (Exception e) {
            return null;
        }
        return objList;
    }
}
