package com.springcore.factorybean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.factorybean.bean.Alarm;

/**
 * @author bpawar
 *
 */
@SuppressWarnings("deprecation")
public class FactoryBeanApplication {

	public static void main(String[] args) {

		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));

		Alarm alarm = container.getBean(Alarm.class);
		alarm.irritate();
	}
}
