package com.aop.declarative.after.aspect;

import org.aspectj.lang.JoinPoint;

/**
 * @author bpawar
 *
 */
public class KeyCheckerAspect {

	public void keyChecker(JoinPoint joinPoint, Object output) {

		if (((String) output.toString()).length() <= 10) {
			throw new IllegalArgumentException("Weak key generated, key is: " + output);
		}
	}
}
