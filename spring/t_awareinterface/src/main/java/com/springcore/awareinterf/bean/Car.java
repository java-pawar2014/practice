package com.springcore.awareinterf.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author bpawar
 *
 */
public class Car implements BeanFactoryAware {

	private Engine engine;
	private String beanId;

	private BeanFactory container;

	public Car(String beanId) {
		System.out.println("Invoked Car(String)");
		this.beanId = beanId;
	}

	public void drive() {
		engine = container.getBean(beanId, Engine.class);
		engine.start();
		System.out.println("Driving the car...");
	}

	@Override
	public void setBeanFactory(BeanFactory container) throws BeansException {
		System.out.println("Invoked setBeanFactory(BeanFactory)");
		this.container = container;
	}
}
