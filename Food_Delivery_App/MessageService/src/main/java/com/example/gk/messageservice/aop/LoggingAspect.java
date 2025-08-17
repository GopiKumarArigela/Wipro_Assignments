package com.example.gk.messageservice.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    // Pointcut for all methods in controllers
    @Pointcut("within(com.example.gow.messageservice.controller..*)")
    public void controllerMethods() {}

    // Pointcut for all methods in services
    @Pointcut("within(com.example.gow.messageservice.service..*)")
    public void serviceMethods() {}

    // Before advice for controllers
    @Before("controllerMethods()")
    public void logControllerMethodCall(JoinPoint joinPoint) {
        log.info("Controller call: {}.{}() with args: {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));
    }

    // AfterReturning advice for controllers
    @AfterReturning(pointcut = "controllerMethods()", returning = "result")
    public void logControllerReturn(JoinPoint joinPoint, Object result) {
        log.info("Controller returned from {}.{}() with value: {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                result);
    }

    // Before advice for services
    @Before("serviceMethods()")
    public void logServiceMethodCall(JoinPoint joinPoint) {
        log.info("Service call: {}.{}() with args: {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));
    }

    // AfterReturning advice for services
    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logServiceReturn(JoinPoint joinPoint, Object result) {
        log.info("Service returned from {}.{}() with value: {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                result);
    }

    // Exception logging (optional)
    @AfterThrowing(pointcut = "controllerMethods() || serviceMethods()", throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        log.error("Exception in {}.{}(): {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                ex.getMessage());
    }
}
