package com.agsft.springaudit.exception;

import org.springframework.http.HttpStatus;


public class ConversionException extends AuditingException {

	private static final long serialVersionUID = 2157872532142159136L;

	public ConversionException(String message) {
		super(HttpStatus.EXPECTATION_FAILED.value(), message);
	}
}
