package com.springcore.consconf;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.consconf.bean.Robot;

@SuppressWarnings("deprecation")
public class ConstructorConfApplication {

	public static void main(String[] args) {
		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		Robot robot = (Robot) container.getBean("robot");
		System.out.println(robot);
	}
}
