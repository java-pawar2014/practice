/**
 * 
 */
package com.aop.programmatic.after.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * @author bpawar
 *
 */
public class KeyValidatorAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

		if ((Integer) returnValue <= 0) {
			throw new IllegalArgumentException("The generated key is not valid key.");
		} else {
			System.out.println("Strong and valid key is generated.");
		}
	}
}
