package com.springboot.mongodb.status;

public enum Status {
	/**
	 */
	SAVE_SUCCESS(228, "Data saved successfully"),
	/**
	 */
	SAVE_FAIL(539, "Application error, failed to save data"),
	/**
	 */
	UPDATE_FAIL(540, "Application error, failed to update data"),
	/**
	 */
	UPDATE_SUCCESS(229, "Data updated successfully"),
	/**
	 */
	DELETE_FAIL(541, "Application error, failed to delete"),
	/**
	 */
	DELETE_SUCCESS(230, "Application error, failed to delete"),
	/**
	 */
	FETCHED(200, "Data fetched successfully"),
	/**
	 */
	BINDING_ERROR(501, "Request data binding error"),
	/**
	 */
	NO_DATA(204, "No data found");

	private final int value;
	private final String message;

	Status(int value, String message) {
		this.value = value;
		this.message = message;
	}

	public int value() {
		return value;
	}

	public String message() {
		return message;
	}
}
