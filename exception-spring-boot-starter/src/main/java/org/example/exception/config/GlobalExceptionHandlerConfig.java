package org.example.exception.config;


import org.example.exception.controller.GlobalExceptionHandler;
import org.example.exception.interceptor.GlobalInterceptor;
import org.example.exception.interceptor.WebConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalExceptionHandlerConfig {

    @Bean
    public GlobalExceptionHandler newGlobalExceptionHandler(){
        return new GlobalExceptionHandler();
    }

    @Bean
    public GlobalInterceptor newGlobalInterceptor(){
        return new GlobalInterceptor();
    }

    @Bean
    public WebConfig newWebconfig(){
        return new WebConfig();
    }
}
