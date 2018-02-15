package com.springcore.dependson.bean;

import java.util.Properties;

import com.springcore.dependson.constant.PropertiesKey;
import com.springcore.dependson.util.Cache;

/**
 * @author bpawar
 *
 */
public class LoanCalculator {
	private Cache cache;

	public double calculateInterest(long principalAmt, int tenure, String city) {
		float interestRate = 0.0f;
		double amount = 0.0f;
		Properties cities = null;

		cities = (Properties) getCache().get(PropertiesKey.CITY_INTEREST.getValue());

		if (cities == null) {
			throw new RuntimeException("Internal error.");

		}
		if (!cities.containsKey(city)) {
			throw new RuntimeException("City not found.");
		}
		interestRate = Float.parseFloat(cities.getProperty(city));
		amount = (principalAmt * tenure * interestRate) / 100;
		return amount;
	}

	public Cache getCache() {
		return cache;
	}

	public void setCache(Cache cache) {
		this.cache = cache;
	}

}
