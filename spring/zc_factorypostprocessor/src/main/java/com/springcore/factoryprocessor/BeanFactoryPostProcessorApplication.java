package com.springcore.factoryprocessor;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.factoryprocessor.bean.ConnectionManager;

@SuppressWarnings("deprecation")
public class BeanFactoryPostProcessorApplication {

	public static void main(String[] args) {

		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));

		BeanFactoryPostProcessor postProcessor = container.getBean(BeanFactoryPostProcessor.class);

		postProcessor.postProcessBeanFactory((ConfigurableListableBeanFactory) container);
		ConnectionManager connectionManager = container.getBean(ConnectionManager.class);
		System.out.println(connectionManager);
	}
}
