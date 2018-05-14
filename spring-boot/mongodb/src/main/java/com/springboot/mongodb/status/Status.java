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
	FETCHED(200, "Data fetched successfully"),
	/**
	 */
	BINDING_ERROR(501, "Request data binding error"),
	/**
	 **/
	NO_DATA(204, "No data found");

	private final int value;

	private final String statusMessage;

	Status(int value, String statusMessage) {
		this.value = value;
		this.statusMessage = statusMessage;
	}

	public int getValue() {
		return value;
	}

	public String getStatusMessage() {
		return statusMessage;
	}
}
