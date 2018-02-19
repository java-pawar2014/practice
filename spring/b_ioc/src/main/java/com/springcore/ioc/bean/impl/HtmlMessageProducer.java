package com.springcore.ioc.bean.impl;

import com.springcore.ioc.bean.MessageProducer;

public class HtmlMessageProducer implements MessageProducer {

	public String formatMessage(String message) {
		return "\nThis is HTML message producer.\n" + "Your message is:\n<html><body><h2>" + message + "</h2></body></html>";
	}
}
