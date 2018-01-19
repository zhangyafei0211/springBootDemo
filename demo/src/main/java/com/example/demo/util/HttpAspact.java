package com.example.demo.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspact {
    private static final Logger logger = LoggerFactory.getLogger(HttpAspact.class);

    @Pointcut("execution(public * com.example.demo.controller.UserController.*(..))")
    public void all(){

    }

    @Before("all()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //Ip
        logger.info("Ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("all()")
    public void doAfter(){
        logger.info("方法执行后。。。");
    }
    @AfterReturning(returning = "object" ,pointcut = "all()")
    public void doAfterReturning(Object object){
        logger.info("object={}",object.toString());
    }
}
