package org.example.exception.annotation;


import org.example.exception.config.GlobalExceptionHandlerConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({GlobalExceptionHandlerConfig.class})
public @interface EnableGlobalExceptionHandler {
}
