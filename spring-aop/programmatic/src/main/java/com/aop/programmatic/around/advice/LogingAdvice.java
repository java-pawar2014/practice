package com.aop.programmatic.around.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.aop.programmatic.around.service.Calculator;

/**
 * @author bpawar
 *
 */
public class LogingAdvice implements MethodInterceptor {

	/**
	 * This method is overridden for applying additional functionality in accessing
	 * the methods of {@link Calculator} class.
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = null;
		Object[] args = null;

		// Get method name
		methodName = invocation.getMethod().getName();
		// Get arguments
		args = invocation.getArguments();

		System.out.print("Entered into method " + methodName + "(");
		for (int i = 0; i < args.length; i++) {
			if (i == 0) {
				System.out.print(args[0]);
				continue;
			}
			System.out.print(", " + args[i]);
		}
		System.out.println(")");
		// Modify input values
		args[0] = (int) args[0] + 2;
		args[1] = (int) args[1] + 3;

		// Calling original method of target class
		int value = (Integer) invocation.proceed();
		// Modify returned output
		value = value + 10;
		System.out.println("Exited from method " + methodName + "() with return value " + value);
		// Returning output
		return value;
	}
}
