package com.agsft.springaudit.web.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WebResponse implements Serializable {

	private static final long serialVersionUID = -1360948409933724186L;

	private int statusCode;
	private String message;
	private Object responseBody;

	public WebResponse() {
	}

	public WebResponse(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public WebResponse(int statusCode, String message, Object responseBody) {
		this.statusCode = statusCode;
		this.message = message;
		this.responseBody = responseBody;
	}
}
