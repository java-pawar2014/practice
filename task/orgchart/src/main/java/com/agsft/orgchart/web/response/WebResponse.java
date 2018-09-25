package com.agsft.orgchart.web.response;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Data;

/**
 * The response object to be binded with {@link HttpServletResponse} for
 * processing the request of type {@link HttpServletRequest}
 * 
 * @author bpawar
 *
 */
@ResponseBody
@Data
public class WebResponse implements Serializable {

	private static final long serialVersionUID = 8922475076076713862L;

	/**
	 * The response status code
	 */
	private Integer responseStatusCode;

	/**
	 * The response message
	 */
	private String responseMessage;

	/**
	 * The response body
	 */
	private Object responseBody;

	public WebResponse() {
	}

	/**
	 * Instantiates all states of this by the provided values of
	 * <code>responseStatusCode</code>, <code>responseMessage</code> and
	 * <code>responseBody</code>.
	 * 
	 * @param responseStatusCode
	 *            the response status code
	 * @param responseMessage
	 *            the response status code
	 * @param responseBody
	 *            the response body
	 */
	public WebResponse(Integer responseStatusCode, String responseMessage, Object responseBody) {
		this.responseStatusCode = responseStatusCode;
		this.responseMessage = responseMessage;
		this.responseBody = responseBody;
	}

	/**
	 * Instantiates states of this by the provided values of
	 * <code>responseStatusCode</code> and <code>responseMessage</code><br>
	 * The body must be null for this initialization.
	 * 
	 * @param responseStatusCode
	 *            the response status code
	 * @param responseMessage
	 *            the response status code
	 */
	public WebResponse(Integer responseStatusCode, String responseMessage) {
		this.responseStatusCode = responseStatusCode;
		this.responseMessage = responseMessage;
	}

}
