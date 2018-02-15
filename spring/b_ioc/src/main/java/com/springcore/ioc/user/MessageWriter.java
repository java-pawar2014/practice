package com.springcore.ioc.user;

import com.springcore.ioc.bean.MessageProducer;
//import com.springcore.ioc.bean.factory.MessageProducerFactory;
import com.springcore.ioc.bean.impl.HtmlMessageProducer;
import com.springcore.ioc.bean.impl.TextMessageProducer;

/**
 * 
 * Level 1
 * @author bpawar
 *
 */

/*
 
public class MessageWriter {

	private MessageProducer messageProducer;

	public void writeMessage(String message) {
		messageProducer = new HtmlMessageProducer(); // Concrete instantiation for HTML, tight coupling
		// messageProducer = new TextMessageProducer(); // Concrete instantiation for Text, tight coupling
		String formattedMessage = messageProducer.formatMessage(message);
		System.out.println(formattedMessage);
	}
}

*/


/**
 * 
 * Level 2
 * @author bpawar
 *
 */
/*
public class MessageWriter {

	private MessageProducer messageProducer;

	public void writeMessage(String message) {
		
		messageProducer  = MessageProducerFactory.createMessageProducer("text"); // logical name, bit coupling
		//messageProducer  = MessageProducerFactory.createMessageProducer("html"); // logical name, bit coupling
		
		String formattedMessage = messageProducer.formatMessage(message);
		System.out.println(formattedMessage);
	}
}
*/

/**
 * Level 3
 * @author bpawar
 *
 */
public class MessageWriter {

	private MessageProducer messageProducer;

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

