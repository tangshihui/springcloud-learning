package org.example.exception.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.exception.annotation.DisableGlobalExceptionHandler;
import org.example.exception.model.BizResponse;
import org.example.exception.model.NotFoundException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;


@RestControllerAdvice
public class GlobalExceptionHandler implements ResponseBodyAdvice<Object> {

    @ExceptionHandler(value = NullPointerException.class)
    public BizResponse exceptionHandler(HttpServletRequest req, NullPointerException e) {
        return BizResponse.Error("null exception. Error:" + e.getMessage());
    }


    @ExceptionHandler(value = NotFoundException.class)
    public BizResponse notFoundExceptionHandler(HttpServletRequest req, NotFoundException e) {
        return BizResponse.Error(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public BizResponse allExceptionHandler(HttpServletRequest req, Exception e) {
        return BizResponse.Error(e.getMessage());
    }


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        DisableGlobalExceptionHandler disable = (DisableGlobalExceptionHandler) request.getAttribute("DisableGlobalExceptionHandler");
        return disable == null;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //response.getHeaders().setContentType(MediaType.APPLICATION_JSON);

        if (body instanceof BizResponse) {
            return body;
        } else if (body instanceof String) {
            return toJson(BizResponse.OK(body));
            //return BizResponse.OK(body);
        }

//        selectedConverterType = MappingJackson2HttpMessageConverter.class;
        return BizResponse.OK(body);
    }


    private Object toJson(BizResponse<?> r) {
        try {
            //int i = 0;
            //int b = 1/ i;
            return new ObjectMapper().writeValueAsString(r);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}