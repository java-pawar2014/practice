package com.agsft.orgchart.enums;

/**
 * @author bpawar
 *
 */
public enum ECommonMessages {

	ID_NOT_NULL_EMPTY("id must not be null or empty."),
	/**
	 */
	ID_NOT_NULL("id must not be null."),
	/**
	 */
	ID_NOT_EMPTY("id must not be empty."),
	/**
	 */
	PARAM_NOT_NULL_EMPTY("parameter must not be null or empty");

	String message;

	private ECommonMessages(String message) {
		this.message = message;
	}

	public String message() {
		return message;
	}

}
