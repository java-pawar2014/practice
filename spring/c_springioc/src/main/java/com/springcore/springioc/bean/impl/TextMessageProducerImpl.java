package com.springcore.springioc.bean.impl;

import com.springcore.springioc.bean.MessageProducer;

public class TextMessageProducerImpl implements MessageProducer {

	public String formatMessage(String message) {
		return "This is simple text message producer.\n" + "Your message is: " + message;
	}
}
