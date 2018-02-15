/**
 * 
 */
package com.aop.programmatic.before.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Required;

import com.aop.programmatic.util.SecurityChecker;

/**
 * @author bpawar
 *
 */
public class SecurityCheckAdvice implements MethodBeforeAdvice {

	private SecurityChecker securityChecker;

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// Check for authentication
		if (securityChecker.authenticate() == false) {
			throw new IllegalAccessException("Sorry, you are not logged in...");
		}
		System.out.println("Security check completed... You are logged in...");
	}

	@Required
	public void setSecurityChecker(SecurityChecker securityChecker) {
		this.securityChecker = securityChecker;
	}
}
