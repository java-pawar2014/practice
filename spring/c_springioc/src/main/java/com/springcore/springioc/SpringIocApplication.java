package com.springcore.springioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.springioc.user.MessageWriter;

@SuppressWarnings("deprecation")
public class SpringIocApplication {
	public static void main(String[] args) {

		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		MessageWriter messageWriter = (MessageWriter) container.getBean("messageWriter");
		messageWriter.writeMessage("Hey Mr. Xyz, have a nice day...");
	}
}
