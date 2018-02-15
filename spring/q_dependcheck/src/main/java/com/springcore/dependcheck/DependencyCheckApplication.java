package com.springcore.dependcheck;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.dependcheck.bean.Motor;

/**
 * @author bpawar
 *
 */
@SuppressWarnings("deprecation")
public class DependencyCheckApplication {

	public static void main(String[] args) {
		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		System.out.println(container.getBean("motor", Motor.class));
	}
}
