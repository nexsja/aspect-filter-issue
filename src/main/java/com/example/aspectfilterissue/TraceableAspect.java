package com.example.aspectfilterissue;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Aspect
@Component
public class TraceableAspect {

    @Around("@annotation(Traceable)")
    public Object advice(ProceedingJoinPoint pjp) throws Throwable {
        try {
            MDC.put("traceId", UUID.randomUUID().toString());
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        } finally {
            MDC.remove("traceId");
        }
    }
}
