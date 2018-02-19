package com.springcore.springioc.service.impl;

import com.springcore.springioc.service.MessageProducer;

public class TextMessageProducerImpl implements MessageProducer {

	public String formatMessage(String message) {
		return "This is simple text message producer.\n" + "Your message is: " + message;
	}
}
