package com.dinesh.Spring.DataRest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
@Aspect
public class PerformanceMonitoring {
    private static final Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitoring.class);
    @Around("execution(* com.dinesh.Spring.DataRest.Service.JobService.*(..))")
    public Object Around(ProceedingJoinPoint jp) throws Throwable {
        long start  = System.currentTimeMillis();
        Object obj = jp.proceed();
        long end = System.currentTimeMillis();
        LOGGER.info("The Time Taken to execute the method is "+(end-start)+"milliseconds");
        return obj;
    }




}
