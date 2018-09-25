package com.agsft.mongotx.application.common;

public enum Message {

	FETCHED("Data fetched successfully");

	private String value;

	private Message(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

}
