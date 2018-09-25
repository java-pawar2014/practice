package com.agsft.orgchart.enums;

/**
 * @author bpawar
 *
 */
public enum EEmployee {
	/**
	 */
	SAVE_SUCCESS("Employee saved successfully"),
	/**
	 */
	SAVE_FAIL("Failed to save Employee"),
	/**
	 */
	UPDATE_SUCCESS("Employee updated successfully"),
	/**
	 */
	UPDATE_FAIL("Failed to update Employee"),
	/**
	 */
	NOT_FOUND("Employee(s) not found"),
	/**
	 */
	DUPLICATE("Employee is exist with "),
	/**
	 */
	NOT_EXIST("Employee is not exist with "),
	/**
	 */
	REMOVE_SUCCESS("Employee is removed successfully"),
	/**
	 */
	REMOVE_FAIL("Failed to remove Employee");

	String value;

	private EEmployee(String value) {
		this.value = value;
	}

	/**
	 * @return instantiated <code>enum</code> value
	 */
	public String value() {
		return value;
	}
}
