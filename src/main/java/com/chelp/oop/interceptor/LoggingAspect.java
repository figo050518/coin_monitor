package com.chelp.oop.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * 面向service切面编程  记录接口执行时间
 */

@Aspect
@Component
public class LoggingAspect {
    //日志记录
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 统计Service中方法调用的时间
     * @param joinPoint
     * @throws Throwable
     */
    @Around("execution(* com.chelp.oop.service..*.*(..))")
    public Object logServiceMethodAccess(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long t = end - start;
        String tmp = joinPoint.getSignature().toString();
        logger.info(String.format("class:%s,invoke_time:%s",tmp,t+"ms"));
        //System.out.print(tmp+"----------------------------------"+t);

        return object;


    }
}
