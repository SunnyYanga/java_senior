package com.yang.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author yg
 * @date 2020/4/25 12:14
 */
@Component("logger")
@Aspect
@ComponentScan(basePackages = "com.yang")
@EnableAspectJAutoProxy
public class Logger {
    @Pointcut("execution(* com.yang.service.impl.*(..))")
    private void pt1(){}

    @Before("pt1()")
    public void printLog(){
        System.out.println("日志");
    }

    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtn = null;
        try {
            Object[] args = pjp.getArgs();
            System.out.println("日志");
            rtn = pjp.proceed(args);
            return rtn;
        } catch (Throwable t) {
            throw new RuntimeException(t);
        } finally {

        }



    }
}
