package com.aop.annotated.after.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author bpawar
 *
 */
@Component
@Aspect
public class KeyCheckerAspect {
	
	private Logger logger = Logger.getLogger(KeyCheckerAspect.class);
	
	//@Pointcut("execution(* com.aop.annotated.after.service.KeyGenerator.*(..))")
	@Pointcut("bean(keyGenerator)")
	public void keyGenPointcut() {
		
	}
	
	
	// @AfterReturning(pointcut = "execution(* com.aop.annotated.after.service.KeyGenerator.*(..))", returning = "output")
	@AfterReturning(pointcut = "keyGenPointcut()", returning = "output")
	// @After("keyGenPointcut()")
	public void keyChecker(JoinPoint joinPoint, Object output) {
		logger.info("Checking generated key: " + (String) output);
		if (((String) output).length() <= 2) {
			throw new IllegalArgumentException("Weak key generated.");
		}
		logger.info("Key checking completed, strong key is generated.!");
	}
}
