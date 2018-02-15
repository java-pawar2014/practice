package com.aop.programmatic.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author bpawar
 *
 */
public class MethodCache {
	private static MethodCache methodCache;
	public static Map<String, Object> methodMap;

	private MethodCache() {
		methodMap = new ConcurrentHashMap<String, Object>();
	}

	public static synchronized MethodCache getMethodCache() {
		if (methodCache == null) {
			methodCache = new MethodCache();
		}
		return methodCache;
	}

	public Map<String, Object> getMethodMap() {
		return methodMap;
	}

	public void put(String key, Object value) {
		methodMap.put(key, value);
	}

	public Object get(String key) {
		return methodMap.get(key);
	}

	public boolean containsKey(String key) {
		return methodMap.containsKey(key);
	}

}
