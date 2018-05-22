package com.springboot.mongodb.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.mongodb.response.UniversalResponse;

@ControllerAdvice
public class UniversalExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(UniversalExceptionHandler.class);

	public UniversalExceptionHandler() {
		LOGGER.info("Initialized UniversalExceptionHandler");
	}

	@ExceptionHandler(MongoApplicationException.class)
	public ResponseEntity<UniversalResponse> mongoApplicationException(MongoApplicationException exception) {
		LOGGER.info("Exception caught");
		UniversalResponse response = new UniversalResponse();
		response.setData(exception.getData());
		response.setStatusCode(exception.getStatusCode());
		response.setStatusMessage(exception.getStatusMessage());
		response.setResponseMessage(exception.getResponseMessage());
		return ResponseEntity.ok(response);
	}

}
