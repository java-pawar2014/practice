package com.agsft.orgchart.web.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.agsft.orgchart.web.exception.OrgchartException;
import com.agsft.orgchart.web.response.WebResponse;

import lombok.NoArgsConstructor;

/**
 * The global exception handler for each exception mentioned at
 * {@link ExceptionHandler} at member method of this.
 * 
 * @author bpawar
 *
 */
@ControllerAdvice
@NoArgsConstructor
public class OrgchartExceptionHandler {

	/**
	 * Exception handler for exception {@link OrgchartException} which handle
	 * sending response to the client by wrapping status and message to it.
	 * 
	 * @param cause
	 *            instance of the thrown exception
	 * @return simplified response with response status, message and body
	 */
	@ExceptionHandler(value = { OrgchartException.class })
	public ResponseEntity<WebResponse> orgchartExceptionHandler(OrgchartException cause) {
		WebResponse response = new WebResponse(cause.getStatusCode(), cause.getMessage(), cause.getData());
		return ResponseEntity.ok(response);
	}
}
