package com.springcore.autowire;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.autowire.bean.Humpty;

/**
 * @author bpawar
 *
 */
@SuppressWarnings("deprecation")
public class AutowiringApplication {

	public static void main(String[] args) {
		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		Humpty humpty = container.getBean(Humpty.class);

		System.out.println(humpty);
	}
}
