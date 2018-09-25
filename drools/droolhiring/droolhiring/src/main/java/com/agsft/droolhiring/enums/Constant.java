package com.agsft.droolhiring.enums;

/**
 * @author bpawar
 * @since 13-Aug-2018
 */
public enum Constant {

	KIE_RULES("kie-rules");

	private String value;

	private Constant(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

}
