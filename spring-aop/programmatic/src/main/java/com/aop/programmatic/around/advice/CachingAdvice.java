package com.aop.programmatic.around.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.aop.programmatic.util.MasterCache;
import com.aop.programmatic.util.MethodCache;

/**
 * @author bpawar
 *
 */
public class CachingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		MasterCache masterCache = null;
		MethodCache methodCache = null;
		Method method = null;
		String methodName = null;
		Object[] args = null;
		String signature = null;
		String key = null;
		Object value = null;

		method = invocation.getMethod();
		args = invocation.getArguments();
		signature = methodSignature(method);
		key = methodKey(methodName, args);

		masterCache = MasterCache.getMasterCache();
		methodCache = MethodCache.getMethodCache();
		System.out.println("before advise");
		if (masterCache.containsKey(signature) == true) {
			if (methodCache.containsKey(key) == true) {
				return methodCache.get(key);
			}
		}

		value = invocation.proceed();
		methodCache.put(key, value);
		masterCache.put(signature, methodCache.getMethodMap());
		System.out.println("after advise");
		return value;
	}

	private String methodSignature(Method method) {
		StringBuilder signature = null;
		Class<?>[] args = null;
		signature = new StringBuilder();

		signature.append(method.getName()).append("(");
		args = method.getParameterTypes();
		for (int i = 0; i < args.length; i++) {
			if (i == 0) {
				signature.append(args[i].getTypeName());
				continue;
			}
			signature.append(",").append(args[i].getTypeName());
		}
		signature.append(")");
		return signature.toString();
	}

	private String methodKey(String methodName, Object[] args) {

		StringBuilder methodKey = null;

		methodKey = new StringBuilder();
		methodKey.append(methodName).append("(");
		for (int i = 0; i < args.length; i++) {
			if (i == 0) {
				methodKey.append(args[i]);
				continue;
			}
			methodKey.append(",").append(args[i]);
		}
		methodKey.append(")");
		return methodKey.toString();
	}
}
