package com.aop.declarative.before.aspect;

import org.aspectj.lang.JoinPoint;

import com.aop.declarative.util.SecurityChecker;

/**
 * @author bpawar
 *
 */
public class SecurityCheckAspect{
	
	private SecurityChecker securityChecker;
	
	public void secured(JoinPoint joinPoint) throws Throwable {
		// Check for authentication
		if (securityChecker.authenticate() == false) {
			throw new IllegalAccessException("Sorry, you are not logged in...");
		}
		System.out.println("Security check completed... You are now logged in...");
	}

	public SecurityChecker getSecurityChecker() {
		return securityChecker;
	}

	public void setSecurityChecker(SecurityChecker securityChecker) {
		this.securityChecker = securityChecker;
	}
}
