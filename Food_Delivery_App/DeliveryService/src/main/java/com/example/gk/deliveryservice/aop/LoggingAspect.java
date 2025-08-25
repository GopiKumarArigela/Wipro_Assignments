package com.example.gk.deliveryservice.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    // Log method entry
    @Before("execution(* com.example.gow..service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Entering: {} with arguments: {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    // Log method exit
    @AfterReturning(pointcut = "execution(* com.example.gow..service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("Exiting: {} with result: {}", joinPoint.getSignature(), result);
    }

    // Log exceptions
    @AfterThrowing(pointcut = "execution(* com.example.gow..service.*.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        log.error("Exception in {} with cause = {}", joinPoint.getSignature(), ex.getMessage());
    }
}

