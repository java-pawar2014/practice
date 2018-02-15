package com.springcore.awareinterf;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.awareinterf.bean.Car;

/**
 * @author bpawar
 *
 */
@SuppressWarnings("deprecation")
public class AwareInterfaceApplication {

	public static void main(String[] args) {
		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		Car car = container.getBean(Car.class);
		car.drive();
	}
}
