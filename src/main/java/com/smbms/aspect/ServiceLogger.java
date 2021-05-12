package com.smbms.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class ServiceLogger {
   // @Pointcut("execution(* com.smbms.service..*.*(..))")
   // public void cut(){}
    private static Logger log=Logger.getLogger(ServiceLogger.class);

    /**
     * 环绕增强
     * @param point
     * @return
     */
  //  @Around(value = "cut()")
    public Object around(ProceedingJoinPoint point){
        Object result=null;
        Object[] args = point.getArgs();
        try {
            //前置通知
            log.info("环绕通知-前置通知\t调用"+point.getTarget()+"的"+point.getSignature().getName()+"方法。方法入参:"+ Arrays.toString(point.getArgs()));
            //调用对应的方法
            result= point.proceed(args);
            //返回通知
            log.info("环绕通知-返回通知\t调用"+point.getTarget()+"的"+point.getSignature().getName()+"方法,方法返回值:"+result);
        }catch (Throwable throwable){
            log.error("环绕通知-异常通知..."+throwable);
        }
        log.info("环绕通知-最终通知...");
        return result;
    }
}
