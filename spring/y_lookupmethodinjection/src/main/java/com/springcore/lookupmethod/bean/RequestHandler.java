package com.springcore.lookupmethod.bean;

public class RequestHandler {

	private String data;

	public void setData(String data) {
		this.data = data;
	}

	public void handle() {
		System.out.println("Processing request with data: " + data);
	}
}
