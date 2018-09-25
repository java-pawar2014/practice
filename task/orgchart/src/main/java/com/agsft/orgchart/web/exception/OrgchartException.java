package com.agsft.orgchart.web.exception;

import com.agsft.orgchart.web.exception.handler.OrgchartExceptionHandler;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The common exception of the application which may be thrown from anywhere,
 * but recommended to throw from controllers of this application.<br>
 * It can be thrown for response which will be handled by
 * {@link OrgchartExceptionHandler}.
 * 
 * @see OrgchartExceptionHandler
 * @author bpawar
 *
 */
@NoArgsConstructor
@Getter
@Setter
public class OrgchartException extends Exception {

	private static final long serialVersionUID = 6190883483932194149L;

	/**
	 * The response status code
	 */
	private Integer statusCode;

	/**
	 * The response message
	 */
	private String message;

	/**
	 * The response body
	 */
	private Object data;

	public OrgchartException(Integer statusCode, String message, Object data) {
		super(message);
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}

	public OrgchartException(Integer statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
		this.message = message;
	}

	public OrgchartException(String message) {
		super(message);
		this.message = message;
	}
}
