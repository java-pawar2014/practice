package com.spring.aop.tx.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.stereotype.Component;

@Component("loggingAroundAspect")
public class LoggingAroundAspect {

	public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {

		Object output = null;
		Logger logger = null;
		Class<?> clazz = null;
		Signature signature = null;

		clazz = joinPoint.getTarget().getClass();
		logger = Logger.getLogger(clazz);
		signature = joinPoint.getSignature();
		logger.info("Invoked " + signature + "...");
		output = joinPoint.proceed();
		logger.info("Execution of " + signature + " is completed..!");
		return output;
	}
}
