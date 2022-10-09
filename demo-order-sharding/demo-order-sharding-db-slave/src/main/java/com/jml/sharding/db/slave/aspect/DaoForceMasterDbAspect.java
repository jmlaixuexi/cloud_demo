package com.jml.sharding.db.slave.aspect;

import org.apache.shardingsphere.api.hint.HintManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * DAO 强制全部走主库
 */
@Aspect
@Component
public class DaoForceMasterDbAspect {

    @Around("execution(* com.jml.sharding.db.slave.dao..*.*(..))")
    public Object around(ProceedingJoinPoint joinpoint) throws Throwable {
        HintManager.getInstance().setMasterRouteOnly();
        return joinpoint.proceed();
    }

}
