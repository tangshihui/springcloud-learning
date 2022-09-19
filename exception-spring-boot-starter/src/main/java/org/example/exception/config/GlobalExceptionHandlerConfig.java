package org.example.exception.config;


import org.example.exception.controller.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalExceptionHandlerConfig {

    @Bean
    public GlobalExceptionHandler newGlobalExceptionHandler(){
        return new GlobalExceptionHandler();
    }
}
