package com.springboot.mongodb.response;

import java.io.Serializable;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UniversalResponse implements Serializable {

	private static final long serialVersionUID = 6620084280918351286L;

	private Integer statusCode;
	private String statusMessage;
	private String responseMessage;
	private Object data;

	public UniversalResponse() {
	}

	public UniversalResponse(Integer statusCode, String statusMessage, String responseMessage, Object data) {
		super();
		this.statusMessage = statusMessage;
		this.statusCode = statusCode;
		this.responseMessage = responseMessage;
		this.data = data;
	}

	public UniversalResponse(Integer statusCode, String statusMessage, String responseMessage) {
		super();
		this.statusMessage = statusMessage;
		this.statusCode = statusCode;
		this.responseMessage = responseMessage;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
