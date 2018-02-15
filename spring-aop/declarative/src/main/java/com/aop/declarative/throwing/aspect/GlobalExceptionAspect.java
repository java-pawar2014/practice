package com.aop.declarative.throwing.aspect;

import org.aspectj.lang.JoinPoint;

/**
 * @author bpawar
 *
 */
public class GlobalExceptionAspect {

	public void exception(JoinPoint joinPoint, IndexOutOfBoundsException cause) {
		try {
			System.out.println("In exception cause handler: " + cause.getCause());
		} catch (IndexOutOfBoundsException e) {
			throw new ClassCastException();
		}
	}
}
