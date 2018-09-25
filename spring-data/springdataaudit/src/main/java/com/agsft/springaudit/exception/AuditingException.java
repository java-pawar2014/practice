package com.agsft.springaudit.exception;

import lombok.Getter;

@Getter
public class AuditingException extends Exception {

	private static final long serialVersionUID = 7585756731432140869L;

	private int statusCode;
	private String message;
	private Object responseBody;

	public AuditingException(int statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
		this.message = message;
	}

	public AuditingException(int statusCode, String message, Object responseBody) {
		super(message);
		this.statusCode = statusCode;
		this.message = message;
		this.responseBody = responseBody;
	}

}
