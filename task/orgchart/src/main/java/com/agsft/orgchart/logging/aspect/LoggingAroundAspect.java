package com.agsft.orgchart.logging.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@Aspect
@NoArgsConstructor
public class LoggingAroundAspect {

	@Pointcut(value = "execution(* com.agsft.orgchart.web.controller.*.*(..)) || "
			+ "execution(* com.agsft.orgchart.service.handler.*.*(..)) || "
			+ "execution(* com.agsft.orgchart.web.exception.handler.*.*(..)) || "
			+ "execution(* com.agsft.orgchart.util.*.*(..))")
	public void pointcut() {
		System.out.println("Pointcut created");
	}

	@Around(value = "pointcut()")
	public Object aroundLogging(ProceedingJoinPoint joinPoint) throws Throwable {
		Class<?> clazz = joinPoint.getTarget().getClass();
		Logger logger = LogManager.getLogger(clazz);
		logger.info("Invoked " + methodName(joinPoint));
		Object output = joinPoint.proceed(joinPoint.getArgs());
		logger.info("Exiting from " + methodName(joinPoint) + " with output : " + output);
		return output;
	}

	@AfterThrowing(value = "pointcut()", throwing = "cause")
	public void afterThrowingLogging(JoinPoint joinPoint, Throwable cause) {
		Class<?> clazz = joinPoint.getTarget().getClass();
		Logger logger = LogManager.getLogger(clazz);
		logger.info("Thrown exception and exiting from " + methodName(joinPoint));
	}

	private String methodName(JoinPoint joinPoint) {
		StringBuilder nameBuilder = new StringBuilder();
		nameBuilder.append(joinPoint.getSignature().toShortString());
		return nameBuilder.toString();
	}
}
