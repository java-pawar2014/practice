package com.agsft.mongotx.web.model.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author bpawar
 *
 */
@AllArgsConstructor
@Getter
public class WebResponse implements Serializable {

	private static final long serialVersionUID = 1280410260648717382L;

	private int statusCode;
	private String message;
	private Object responseBody;

	public WebResponse(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
}
