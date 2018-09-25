package com.agsft.mongotx.web.exception;

import lombok.Getter;

/**
 * @author bpawar
 *
 */
@Getter
public class TransactionException extends Exception {

	private static final long serialVersionUID = 7585756731432140869L;

	private int statusCode;
	private String message;
	private Object responseBody;

	public TransactionException(int statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
		this.message = message;
	}

	public TransactionException(int statusCode, String message, Object responseBody) {
		super(message);
		this.statusCode = statusCode;
		this.message = message;
		this.responseBody = responseBody;
	}

}
