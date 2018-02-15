package com.springcore.dependson.constant;

/**
 * @author bpawar
 *
 */
public enum PropertiesKey {

	CITY_INTEREST("city_interest"), INEREST_RATE_BASE("interestrate");

	private String value;

	private PropertiesKey(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
