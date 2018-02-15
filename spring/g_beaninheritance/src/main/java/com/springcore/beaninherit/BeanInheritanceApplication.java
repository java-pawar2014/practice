package com.springcore.beaninherit;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.beaninherit.bean.Car;

public class BeanInheritanceApplication {

	public static void main(String[] args) {
		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		System.out.println(container.getBean("swift1", Car.class));
		System.out.println(container.getBean("swift2", Car.class));
		System.out.println(container.getBean("swift3", Car.class));
	}
}
