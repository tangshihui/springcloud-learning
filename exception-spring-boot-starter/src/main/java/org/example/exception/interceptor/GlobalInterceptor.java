package org.example.exception.interceptor;


import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.example.exception.annotation.DisableGlobalExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class GlobalInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Trace
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestId = request.getParameter("requestId");
        logger.info("requestId:{}", requestId);

        if (requestId != null) {
            TraceContext.putCorrelation("requestId", requestId);
            //ActiveSpan.tag("requestId", requestId);
        }

        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            if (clazz.isAnnotationPresent(DisableGlobalExceptionHandler.class)) {
                request.setAttribute("DisableGlobalExceptionHandler", clazz.getAnnotation(DisableGlobalExceptionHandler.class));
            } else if (method.isAnnotationPresent(DisableGlobalExceptionHandler.class)) {
                request.setAttribute("DisableGlobalExceptionHandler", method.getAnnotation(DisableGlobalExceptionHandler.class));
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        logger.info("postHandle:" + handler.toString());
        logger.info("postHandle:"+modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
        logger.info("afterCompletion:"+exception);
    }
}