package com.springcore.beanscope;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.beanscope.bean.DateFormatter;

/**
 * @author bpawar
 *
 */
@SuppressWarnings("deprecation")
public class BeanScopesApplication {

	public static void main(String[] args) {
		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		DateFormatter formatter1 = container.getBean("dateFormatter", DateFormatter.class);
		DateFormatter formatter2 = container.getBean("dateFormatter", DateFormatter.class);
		System.out.println(formatter1.formatDate("9/22/2016", "MM/dd/yyyy"));
		System.out.println(formatter1 == formatter2);
	}
}
