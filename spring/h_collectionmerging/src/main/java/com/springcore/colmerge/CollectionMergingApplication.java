package com.springcore.colmerge;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author bpawar
 *
 */
@SuppressWarnings("deprecation")
public class CollectionMergingApplication {

	public static void main(String[] args) {
		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		System.out.println(container.getBean("CS1YR1SEM"));
		System.out.println(container.getBean("ECE1YR1SEM"));
	}
}
