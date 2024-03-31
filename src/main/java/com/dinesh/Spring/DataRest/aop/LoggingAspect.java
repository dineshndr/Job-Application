package com.dinesh.Spring.DataRest.aop;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);
    @Before("execution(* com.dinesh.Spring.DataRest.Service.JobService.*(..))")
    public void logBeforeMethodCall()
    {
        LOGGER.info("Method is called before");
    }

    @After("execution(* com.dinesh.Spring.DataRest.Service.JobService.*(..))")
    public void logAfterMethodCall(JoinPoint ju)
    {

        LOGGER.info("Method is called After"+ju.getSignature().getName());
    }
    @AfterReturning("execution(* com.dinesh.Spring.DataRest.Service.JobService.*(..))")
    public void logAfterReturnMethodCall(JoinPoint ju)
    {
        LOGGER.info(ju.getSignature().getName()+"Method is called after return");
    }
    @AfterThrowing("execution(* com.dinesh.Spring.DataRest.Service.JobService.getJob(..))")
    public void logAfterThrowing(JoinPoint ju)
    {
        LOGGER.info(ju.getSignature().getName()+"method is called after Throw");
    }

}
