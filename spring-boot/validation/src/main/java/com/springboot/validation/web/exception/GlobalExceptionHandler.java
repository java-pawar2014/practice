package com.springboot.validation.web.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.validation.web.response.CustomResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = CustomException.class)
	public ResponseEntity<CustomResponse> customExceptionHandler(CustomException exception) {

		CustomResponse customResponse = new CustomResponse(exception.getStatus(), exception.getMessage(), null);

		return ResponseEntity.ok(customResponse);
	}
}
