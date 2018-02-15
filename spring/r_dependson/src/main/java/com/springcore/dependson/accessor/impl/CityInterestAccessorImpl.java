package com.springcore.dependson.accessor.impl;

import java.util.Properties;
import java.util.ResourceBundle;

import com.springcore.dependson.accessor.CityInterestAccessor;
import com.springcore.dependson.constant.PropertiesKey;

/**
 * @author bpawar
 *
 */
public class CityInterestAccessorImpl implements CityInterestAccessor {

	@Override
	public Object getData() {

		ResourceBundle resourceBundle = null;
		Properties properties = null;

		resourceBundle = ResourceBundle.getBundle(PropertiesKey.INEREST_RATE_BASE.getValue());
		properties = new Properties();

		for (String key : resourceBundle.keySet()) {
			properties.put(key, resourceBundle.getObject(key));
		}
		return properties;
	}
}
