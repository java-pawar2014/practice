package com.agsft.orgchart.web.response;

import java.io.Serializable;

public class WebResponse implements Serializable {

	private static final long serialVersionUID = 8922475076076713862L;

	private Integer statusCode;
	private String message;
	private Object data;

	public WebResponse() {
	}

	public WebResponse(Integer statusCode, String message, Object data) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "WebResponse [statusCode=" + statusCode + ", message=" + message + ", data=" + data + "]";
	}
}
