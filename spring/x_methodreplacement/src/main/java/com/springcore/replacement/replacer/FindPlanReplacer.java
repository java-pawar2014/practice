package com.springcore.replacement.replacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

/**
 * @author bpawar
 *
 */
public class FindPlanReplacer implements MethodReplacer {

	private final String METHOD_NAME = "findPlans";

	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {

		if (METHOD_NAME.compareTo(method.getName()) == 0) {
			System.out.println("Age :" + args[0]);
			System.out.println("ZIP :" + args[1]);
			System.out.println("Coverage type :" + args[2]);
			System.out.println("Network type :" + args[3]);
			return "Prashanmantri Awas Yojana";
		}

		return null;
	}

}
