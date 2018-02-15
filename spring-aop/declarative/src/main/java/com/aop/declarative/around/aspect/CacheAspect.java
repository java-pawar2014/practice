package com.aop.declarative.around.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author bpawar
 *
 */
public class CacheAspect {

	private String createMethodSignature(String methodName, Object[] args) {
		StringBuilder signature = null;
		signature = new StringBuilder();
		signature.append(methodName).append("(");
		for (int i = 0; i < args.length; i++) {
			if (i == 0) {
				signature.append(args[0]);
				continue;
			}
			signature.append(",").append(args[i]);
		}
		signature.append(")");
		return signature.toString();
	}

	public Object caching(ProceedingJoinPoint joinPoint) {
		String methodSignature = null;
		// String methodKey = null;
		Object[] args = null;
		String methodName = null;

		methodName = joinPoint.getSignature().getName();
		args = joinPoint.getArgs();
		methodSignature = createMethodSignature(methodName, args);
		System.out.println(methodSignature);
		return null;
	}

}
