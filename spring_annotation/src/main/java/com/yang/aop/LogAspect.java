package com.yang.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author yg
 * @date 2020/5/2 10:21
 */
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.yang.aop.MathCalculator.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"运行。。。 参数列表是{"+ Arrays.asList(args) +"}");
    }

    @After("execution(public int com.yang.aop.MathCalculator.div(int, int))")
    public void logEnd() {
        System.out.println("除法结束");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result) {
        System.out.println("除法正常返回。。。 运行结果是{"+result+"}");
    }

    @AfterThrowing("pointCut()")
    public void logException() {
        System.out.println("除法异常。。。 异常信息是{}");
    }
}
