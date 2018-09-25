package com.agsft.mongotx.web.exception.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.agsft.mongotx.web.exception.TransactionException;
import com.agsft.mongotx.web.model.response.WebResponse;

/**
 * @author bpawar
 *
 */
@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler
	ResponseEntity<WebResponse> transactionException(TransactionException cause) {
		return ResponseEntity.ok(new WebResponse(cause.getStatusCode(), cause.getMessage(), cause.getResponseBody()));
	}

}
