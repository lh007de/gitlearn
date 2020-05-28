#AOP
终于要揭露Aop神秘的面纱了，话不多说，引入依赖

            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-aop</artifactId>
                <version>5.1.9.RELEASE</version>
            </dependency>
            <dependency>
                <groupId>org.aspectj</groupId>
                <artifactId>aspectjrt</artifactId>
                <version>1.9.5</version>
            </dependency>
    
            <dependency>
                <groupId>org.aspectj</groupId>
                <artifactId>aspectjweaver</artifactId>
                <version>1.9.5</version>
            </dependency>
            
            
## 定义切点和advice


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

 运行我们的项目，就能看到Aop起作用了，注意因为我们日志级别默认是Info，所以log.debug在我们控制台是看不到的
 
 为了看到进入和退出的打印日志，我们要单独设置该项目的日志级别为debug
 
    logging.level.root = debug
    
 日志级别如下所示
 
    TRACE < DEBUG < INFO < WARN < ERROR < FATAL
           
 我们在生产环境下，可以采用info以上的优先级，本地调试可以采用info以下的优先级。
 
 
> 该demo 我们配置了swagger,访问方式是 localhost:8080/swagger-ui.html