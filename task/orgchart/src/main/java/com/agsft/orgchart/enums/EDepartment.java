package com.agsft.orgchart.enums;

public enum EDepartment {
	/**
	 */
	SAVE_SUCCESS("Department saved successfully"),
	/**
	 */
	SAVE_FAIL("Failed to save Department"),
	/**
	 */
	UPDATE_SUCCESS("Department updated successfully"),
	/**
	 */
	UPDATE_FAIL("Failed to update Department"),
	/**
	 */
	NOT_FOUND("Department(s) not found"),
	/**
	 */
	DUPLICATE("Department is exist with "),
	/**
	 */
	NOT_EXIST("Department is not exist with "),
	/**
	 */
	REMOVE_SUCCESS("Department is removed successfully"),
	/**
	 */
	REMOVE_FAIL("Failed to remove Department");

	String value;

	private EDepartment(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
