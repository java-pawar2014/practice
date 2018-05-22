package com.springboot.mongodb.util;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

public class ErrorExtractor {

	public static String extractBindingErrors(Errors errors) {
		StringBuilder errorBuilder = new StringBuilder();
		for (FieldError error : errors.getFieldErrors())
			errorBuilder.append(error.getDefaultMessage()).append(". ");
		return errorBuilder.toString();
	}

}
