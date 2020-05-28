package com.lh.aop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName: LogAspect
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/22 12:00
 * @Version: 1.0
 **/
@Component
@Aspect
@Slf4j
public class LogAspect {
//    1.定义切点
    /**
     * Pointcut that matches all repositories, services endpoints.
     * 我们把spring内置的一些包下面的Bean也纳入我们的切点
     */
    @Pointcut("within(@org.springframework.stereotype.Repository *)" +
            " || within(@org.springframework.stereotype.Service *)")
    public void springBeanPointcut() {
    }

    /**
     * 1.2把我们自己结构纳入切点
     */
    @Pointcut("within(com.lh.aop.service..*)"+
            " || within(com.lh.aop.controller..*)")
    public void applicationPackagePointcut() {

    }


//    2.定义Advice

    /**
     * @param joinPoint 连接点
     * @param e 抛出的错误
     * 切点抛出错误的处理:就是打印出具体的错误原因
     */
@AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {

    log.error("Exception in {}.{}() with cause = \'{}\' and exception = \'{}\'", joinPoint.getSignature().getDeclaringTypeName(),
            joinPoint.getSignature().getName(), e.getCause() != null? e.getCause() : "NULL", e.getMessage(), e);
}

    /**
     * Advice that logs when a method is entered and exited.
     *
     * @param joinPoint join point for advice
     * @return result
     * @throws Throwable throws IllegalArgumentException
     */
    @Around("applicationPackagePointcut() && springBeanPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        try {
            Object result = joinPoint.proceed();
            log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), result);
            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());

            throw e;
        }
    }

}
