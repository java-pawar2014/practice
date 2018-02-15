package com.springcore.ioc.bean.impl;

import com.springcore.ioc.bean.MessageProducer;

public class TextMessageProducer implements MessageProducer {

	public String formatMessage(String message) {
		return "This is simple text message producer.\n" + "Your message is: " + message;
	}
}
