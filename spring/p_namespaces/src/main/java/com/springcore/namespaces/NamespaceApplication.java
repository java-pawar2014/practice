package com.springcore.namespaces;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.namespaces.bean.Person;

/**
 * @author bpawar
 *
 */
@SuppressWarnings("deprecation")
public class NamespaceApplication {

	public static void main(String[] args) {
		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		System.out.println(container.getBean(Person.class));
	}
}
