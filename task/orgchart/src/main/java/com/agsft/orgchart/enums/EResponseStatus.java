package com.agsft.orgchart.enums;

/**
 * @author bpawar
 *
 */
public enum EResponseStatus {
	/**
	 */
	NO_CONTENT(442, "No data found"),
	/**
	 */
	BINDING_ERROR(287, "Request data binding error"),
	/**
	 */
	FETCHED(231, "Data fetched successfully"),
	/**
	 */
	FAIL(285, "Failed");
	private Integer statusCode;
	private String message;

	EResponseStatus(Integer statusCode, String message) {
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
