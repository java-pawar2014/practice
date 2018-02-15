package com.springcore.ioc;

import com.springcore.ioc.bean.MessageProducer;
import com.springcore.ioc.bean.factory.ObjectFactory;
import com.springcore.ioc.bean.impl.HtmlMessageProducer;
import com.springcore.ioc.bean.impl.TextMessageProducer;
import com.springcore.ioc.master.Container;
import com.springcore.ioc.user.MessageWriter;

public class IocApplication {

	/*
	 * public static void main(String[] args) { MessageProducer messageProducer =
	 * null; MessageWriter messageWriter = null;
	 * 
	 * messageProducer = (MessageProducer) ObjectFactory
	 * .createMessageProducer("com.springcore.ioc.bean.impl.HtmlMessageProducer");
	 * 
	 * messageWriter = (MessageWriter)
	 * ObjectFactory.createMessageProducer("com.springcore.ioc.user.MessageWriter");
	 * messageWriter.setMessageProducer(messageProducer);
	 * messageWriter.writeMessage("Building spring IOC..."); }
	 */

	public static void main(String[] args) {
		Container container = null;
		System.out.println("Starting container...");
		container = Container.loadContainer(null);
		MessageProducer htmlMessageProducer = (HtmlMessageProducer) container.getObjectMetadata().get("htmlMessageProducer");
		MessageProducer textMessageProducer = (TextMessageProducer) container.getObjectMetadata().get("textMessageProducer");
		MessageWriter messageWriter = (MessageWriter) container.getObjectMetadata().get("messageWriter");
		
		messageWriter.setMessageProducer(htmlMessageProducer);
		messageWriter.writeMessage("Hey Mr. Xyz, have a nice day.");
	}
}
