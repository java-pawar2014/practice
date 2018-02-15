package com.aop.programmatic.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author bpawar
 *
 */
public class MasterCache {

	private static MasterCache masterCache;
	public static Map<String, Object> masterMap;

	private MasterCache() {
		masterMap = new ConcurrentHashMap<String, Object>();
	}

	public static synchronized MasterCache getMasterCache() {
		if (masterCache == null) {
			masterCache = new MasterCache();
		}
		return masterCache;
	}

	public void put(String key, Object value) {
		masterMap.put(key, value);
	}

	public Object get(String key) {
		return masterMap.get(key);
	}

	public boolean containsKey(String key) {
		return masterMap.containsKey(key);
	}
}
