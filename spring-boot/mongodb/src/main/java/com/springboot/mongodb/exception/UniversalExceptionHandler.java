package com.springboot.mongodb.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.mongodb.response.UniversalResponse;
import com.springboot.mongodb.status.Status;

@RestControllerAdvice
public class UniversalExceptionHandler {

	@ExceptionHandler(value = BindException.class)
	public ResponseEntity<UniversalResponse> bindException(BindException bindException,
			@Autowired UniversalResponse response) {

		response.setStatusCode(Status.BINDING_ERROR.getValue());
		response.setStatusMessage(Status.BINDING_ERROR.getStatusMessage());
		response.setResponseMessage(bindException.getMessage());
		return ResponseEntity.ok(response);
	}

	@ExceptionHandler(value = org.springframework.boot.context.properties.bind.BindException.class)
	public ResponseEntity<UniversalResponse> dataBindException(
			org.springframework.boot.context.properties.bind.BindException bindException,
			@Autowired UniversalResponse response) {

		response.setStatusCode(Status.BINDING_ERROR.getValue());
		response.setStatusMessage(Status.BINDING_ERROR.getStatusMessage());
		response.setResponseMessage(bindException.getMessage());
		return ResponseEntity.ok(response);
	}

}
