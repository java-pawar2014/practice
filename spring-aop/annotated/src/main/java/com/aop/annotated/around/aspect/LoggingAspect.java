package com.aop.annotated.around.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("loggingAspect")
@Aspect
public class LoggingAspect {

	@Pointcut("execution(* com.aop.annotated.around.service.Calculator.*(..)) ||"
			+ "execution(* com.aop.annotated.around.service.MobileService.*(..)) ||"
			+ "execution(* com.aop.annotated.before.service.LoanManager.*(..)) ||"
			+ "execution(* com.aop.annotated.throwing.service.GeneralClass.*(..)) ||"
			+ "execution(* com.aop.annotated.after.service.KeyGenerator.*(..))")
	public void pointcut1() {
		// Around advice point cut
	}

	@Around("pointcut1()")
	public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {

		Class<?> clazz = null;
		Object output = null;

		// Two ways to get target class
		// clazz = joinPoint.getSignature().getDeclaringType();
		clazz = joinPoint.getTarget().getClass();
		Logger logger = Logger.getLogger(clazz);
		logger.info("Entered into " + joinPoint.getSignature());
		// Input argument values can modified
		output = joinPoint.proceed();
		logger.info("Exiting from " + joinPoint.getSignature() + " with output: " + output);
		// Output value can be modified
		return output;
	}
}
