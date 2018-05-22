package com.springboot.mongodb.exception;

@SuppressWarnings("serial")
public class MongoApplicationException extends Exception {

	private Integer statusCode;
	private String statusMessage;
	private String responseMessage;
	private Object data;

	public MongoApplicationException(Integer statusCode, String statusMessage, String responseMessage, Object data) {
		super(responseMessage);
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.responseMessage = responseMessage;
		this.data = data;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}