package com.aop.annotated.before.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aop.annotated.util.SecurityChecker;

@Component
@Aspect
public class SecurityCheckAspect {

	private SecurityChecker securityChecker;

	@Pointcut(value = "bean(loanManager)")
	public void pointcut() {

	}

	@Before("pointcut()")
	public void secured(JoinPoint joinPoint) throws Throwable {
		Class<?> clazz = joinPoint.getTarget().getClass();
		Logger logger = Logger.getLogger(clazz);
		logger.info("Security check started...");
		// Check for authentication
		if (securityChecker.authenticate() == false) {
			throw new IllegalAccessException("Sorry, you are not logged in...");
		}
		logger.info("Security check completed... You are now logged in...");
	}

	public SecurityChecker getSecurityChecker() {
		return securityChecker;
	}

	@Autowired(required = true)
	public void setSecurityChecker(SecurityChecker securityChecker) {
		this.securityChecker = securityChecker;
	}
}
