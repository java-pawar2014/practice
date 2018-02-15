package com.springcore.ioc.bean.factory;

import com.springcore.ioc.bean.MessageProducer;
import com.springcore.ioc.bean.impl.HtmlMessageProducer;
import com.springcore.ioc.bean.impl.TextMessageProducer;

/**
 * Level 2
 * 
 * @author bpawar
 *
 */
/*
 * public class MessageProducerFactory {
 * 
 * private static final String TEXT_MESSAGE = "text"; private static final
 * String HTML_MESSAGE = "html";
 * 
 * public static MessageProducer createMessageProducer(String messageType) {
 * MessageProducer messageProducer = null;
 * 
 * if (TEXT_MESSAGE.compareTo(messageType) == 0) { messageProducer = new
 * TextMessageProducer(); } else if (HTML_MESSAGE.compareTo(messageType) == 0) {
 * messageProducer = new HtmlMessageProducer(); }
 * 
 * return messageProducer; } }
 */

public class ObjectFactory {

	public static Object createObject(String clazz) {
		Object messageProducer = null;
		try {
			messageProducer = Class.forName(clazz).newInstance();
		} catch (Throwable cause) {
			System.out.println(cause);
		}
		return messageProducer;
	}
}
