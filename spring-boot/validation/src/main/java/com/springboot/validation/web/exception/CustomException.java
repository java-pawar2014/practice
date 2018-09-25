package com.springboot.validation.web.exception;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1279534103604400687L;
	private int status;
	private String message;

	public CustomException(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
