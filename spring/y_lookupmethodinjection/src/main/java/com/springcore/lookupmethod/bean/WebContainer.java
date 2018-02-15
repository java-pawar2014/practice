package com.springcore.lookupmethod.bean;

public abstract class WebContainer {

	public void process(String data) {
		RequestHandler requestHandler = getRequestHandler();
		requestHandler.setData(data);
		requestHandler.handle();
	}

	public abstract RequestHandler getRequestHandler();
}
