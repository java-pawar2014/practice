package com.aop.programmatic.before.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author bpawar
 *
 */
public class AccessAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println(args[1] + " tried to access " + method.getName() + "() method\nof class"
				+ target.getClass().getName());
	}
}
