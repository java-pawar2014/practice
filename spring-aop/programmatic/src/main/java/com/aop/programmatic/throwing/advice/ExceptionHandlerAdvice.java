package com.aop.programmatic.throwing.advice;

import java.io.IOException;
import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * @author bpawar
 *
 */
public class ExceptionHandlerAdvice implements ThrowsAdvice {

	public void afterThrowing(Method method, Object[] args, Object target, IOException cause) {
		System.out.println("Handling exception occured in " + target.getClass().getName() + "." + method.getName());
		System.out.println("Message is : " + cause.getMessage() + "- " + args[0]);
		System.out.println("Detailed cause is :");
		cause.printStackTrace();
	}
}
