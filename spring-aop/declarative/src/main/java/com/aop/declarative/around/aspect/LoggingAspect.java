package com.aop.declarative.around.aspect;

import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author bpawar
 *
 */
public class LoggingAspect {

	/**
	 * @param joinPoint
	 *            {@link ProceedingJoinPoint}
	 * @return
	 * @throws Throwable
	 */
	public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {

		/**
		 * Code without logger
		 */
/*
 		String methodName = null;
		Object[] args = null;
		Class<?> clazz = null;
		String className = null;

		// Two ways to get target class // clazz =
		joinPoint.getSignature().getClass();
		clazz = joinPoint.getTarget().getClass();
		methodName = joinPoint.getSignature().getName();
		args = joinPoint.getArgs();
		className = clazz.getName();
		System.out.print("Entered into " + className + "." + methodName + "(");
		for (int i = 0; i < args.length; i++) {
			if (i == 0) {
				System.out.print(args[0]);
				continue;
			}
			System.out.print("," + args[i]);
		}
		System.out.println(") at " + new Date());
		Object out = joinPoint.proceed();
		System.out.println("Exiting from " + className + "." + methodName + " with value: " + ((int) out + 1));
		return ((int) out + 1);
*/
		/**
		 * Code with logger
		 */
		String methodName = null;
		Object[] args = null;
		Class<?> clazz = null;
		String className = null;

		// Two ways to get target class
		// clazz = joinPoint.getSignature().getClass();
		clazz = joinPoint.getTarget().getClass();

		Logger logger = Logger.getLogger(clazz);

		methodName = joinPoint.getSignature().getName();
		args = joinPoint.getArgs();
		className = clazz.getName();
		StringBuilder builder = new StringBuilder();
		builder.append("Entered into ").append(joinPoint.getSignature()).append(" with inputs : ");
		for (int i = 0; i < args.length; i++) {
			if (i == 0) {
				builder.append(args[0]);
				continue;
			}
			builder.append("," + args[i]);
		}
		builder.append(".");
		logger.info(builder.toString());
		// We can modify input arguments before calling original method if types are
		// compatible for various point cut executions
		// args[0] = (int) args[0] + 1;
		Object out = joinPoint.proceed();
		logger.info("Exiting from " + className + "." + methodName + " with value: " + out);
		// We can modify the output
		return ((int) out + 1);

	}
}
