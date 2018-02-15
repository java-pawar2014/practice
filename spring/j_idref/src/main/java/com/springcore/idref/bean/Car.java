package com.springcore.idref.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author bpawar
 *
 */
@SuppressWarnings("deprecation")
public class Car {

	private String beanId;

	public void run() {
		Engine engine = null;
		BeanFactory container = null;

		container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		engine = container.getBean(getBeanId(), Engine.class);
		engine.start();
		System.out.println("Driving car...");
	}

	public String getBeanId() {
		return beanId;
	}

	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}
}
