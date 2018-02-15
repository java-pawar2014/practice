package com.springcore.idref;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.idref.bean.Car;

/**
 * @author bpawar
 *
 */
@SuppressWarnings("deprecation")
public class IdReferenceApplication {

	public static void main(String[] args) {

		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));

		Car car = container.getBean("car", Car.class);
		car.run();
	}
}
