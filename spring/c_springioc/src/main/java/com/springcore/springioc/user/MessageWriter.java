package com.springcore.springioc.user;

import com.springcore.springioc.bean.MessageProducer;

public class MessageWriter {

	private MessageProducer messageProducer;

	public MessageWriter(MessageProducer messageProducer) {
		this.messageProducer = messageProducer;
	}

	public void writeMessage(String message) {
		String formattedMessage = getMessageProducer().formatMessage(message);
		System.out.println(formattedMessage);
	}

	public MessageProducer getMessageProducer() {
		return this.messageProducer;
	}

	public void setMessageProducer(MessageProducer messageProducer) {
		this.messageProducer = messageProducer;
	}
}