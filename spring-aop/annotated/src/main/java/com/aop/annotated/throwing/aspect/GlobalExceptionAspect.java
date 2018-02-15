package com.aop.annotated.throwing.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GlobalExceptionAspect {

	@AfterThrowing(pointcut = "bean(generalClass)", throwing = "exn")
	public void exception(JoinPoint joinPoint, IndexOutOfBoundsException exn) {

		System.out.println(exn.getMessage());
	}
}
