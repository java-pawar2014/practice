package com.agsft.orgchart.enums;

/**
 * @author bpawar
 *
 */
public enum ERole {
	/**
	 */
	SAVE_SUCCESS("Role saved successfully"),
	/**
	 */
	SAVE_FAIL("Failed to save Role"),
	/**
	 */
	UPDATE_SUCCESS("Role updated successfully"),
	/**
	 */
	UPDATE_FAIL("Failed to update Role"),
	/**
	 */
	NOT_FOUND("Role(s) not found"),
	/**
	 */
	DUPLICATE("Role is exist with "),
	/**
	 */
	NOT_EXIST("Role is not exist with  "),
	/**
	 */
	REMOVE_SUCCESS("Role is removed successfully"),
	/**
	 */
	REMOVE_FAIL("Failed to remove Role");

	String value;

	private ERole(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
