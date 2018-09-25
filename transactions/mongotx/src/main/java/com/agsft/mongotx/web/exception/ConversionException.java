package com.agsft.mongotx.web.exception;

import org.springframework.http.HttpStatus;

public class ConversionException extends TransactionException {

	private static final long serialVersionUID = 2157872532142159136L;

	public ConversionException(String message) {
		super(HttpStatus.EXPECTATION_FAILED.value(), message);
	}
}
