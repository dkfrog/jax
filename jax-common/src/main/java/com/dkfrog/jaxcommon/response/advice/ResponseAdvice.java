package com.dkfrog.jaxcommon.response.advice;

/**
 * 接口统一标准
 *
 * @author ramos.bh.wu@mail.foxconn.com
 * @date 2020-01-16 15:16
 * @since 1.0.1
 */

import com.dkfrog.jaxcommon.response.ResultDTO;
import com.dkfrog.jaxcommon.utils.JsonUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Map;

@RestControllerAdvice(annotations = RestController.class)
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    private final static String JSON_SIGN = "{";

    @Override
    public boolean supports(MethodParameter parameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o,
                                  MethodParameter parameter,
                                  MediaType type, Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        if (o instanceof String) {
            String jsonStr = (String) o;
            if (jsonStr.contains(JSON_SIGN)) {
                ResultDTO success = ResultDTO.success(JsonUtils.stringToBean(jsonStr, Map.class));
                return JsonUtils.beanToString(success);
            }else {
                return JsonUtils.beanToString(ResultDTO.success(jsonStr));
            }
        } else if (o instanceof ResultDTO) {
            return o;
        }
        return ResultDTO.success(o);
    }
}
