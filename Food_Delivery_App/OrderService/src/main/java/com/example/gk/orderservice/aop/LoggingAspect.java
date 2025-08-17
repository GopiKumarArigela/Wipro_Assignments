package com.example.gk.orderservice.aop;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.example.gow.orderservice.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Method Called: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* com.example.gow.orderservice.service.*.*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        log.info("Method Finished: " + joinPoint.getSignature().getName() + " | Returned: " + result);
    }
}