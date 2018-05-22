package com.agsft.orgchart.enums;

/**
 * @author bpawar
 *
 */
public enum ResponseStatus {
	/**
	 */
	NO_CONTENT(442, "No data found"),
	/**
	 */
	FETCHED(231, "Data fetched successfully");

	private Integer statusCode;
	private String message;

	ResponseStatus(Integer statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public Integer getCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

}
