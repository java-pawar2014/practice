package com.springcore.springioc.service.impl;

import com.springcore.springioc.service.MessageProducer;

public class HtmlMessageProducerImpl implements MessageProducer {

	public String formatMessage(String message) {
		return "This is HTML message producer.\n" + "Your message is:\n<html><body><h2>" + message + "</h2></body></html>";
	}
}
