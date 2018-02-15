package com.springcore.dependson.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author bpawar
 *
 */
public class Cache {

	private Map<String, Object> dataMap;

	private Cache() {

		dataMap = new ConcurrentHashMap<String, Object>();
	}

	public static Cache getCache() {
		Cache cache = null;
		if (cache == null) {
			synchronized (Cache.class) {
				if (cache == null) {
					cache = new Cache();
				}
			}
		}
		return cache;
	}

	public void put(String key, Object value) {
		dataMap.put(key, value);
	}

	public Object get(String key) {
		return dataMap.get(key);
	}

	public boolean containsKey(String key) {
		return dataMap.containsKey(key);
	}
}
