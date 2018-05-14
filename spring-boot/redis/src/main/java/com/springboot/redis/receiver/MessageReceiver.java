package com.springboot.redis.receiver;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageReceiver {

	private static final Logger logger = LoggerFactory.getLogger(MessageReceiver.class);

	private CountDownLatch countDownLatch;

	public void receiveMessage(String message) {
		logger.info("Message received : " + message);
		countDownLatch.countDown();
	}

	@Autowired
	public MessageReceiver(CountDownLatch countDownLatch) {
		super();
		this.countDownLatch = countDownLatch;
	}
}
