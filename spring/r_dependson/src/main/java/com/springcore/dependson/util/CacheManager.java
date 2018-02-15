package com.springcore.dependson.util;

import java.util.Map;

import com.springcore.dependson.accessor.CityInterestAccessor;

/**
 * @author bpawar
 *
 */
public class CacheManager {

	private Cache cache;
	private Map<String, CityInterestAccessor> accessorMap;

	public CacheManager(Cache cache, Map<String, CityInterestAccessor> accessorMap) {
		this.cache = cache;
		this.accessorMap = accessorMap;
		init();
	}

	private void init() {
		Object data = null;
		CityInterestAccessor accessor = null;
		
		for (String dataKey : accessorMap.keySet()) {
			accessor = accessorMap.get(dataKey);
			data = accessor.getData();
			cache.put(dataKey, data);
		}
	}
}
