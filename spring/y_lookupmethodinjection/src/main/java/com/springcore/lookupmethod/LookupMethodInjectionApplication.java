package com.springcore.lookupmethod;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springcore.lookupmethod.bean.WebContainer;

/**
 * @author bpawar
 *
 */
@SuppressWarnings("deprecation")
public class LookupMethodInjectionApplication {

	public static void main(String[] args) {

		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));

		WebContainer webContainer = container.getBean(WebContainer.class);
		webContainer.process("Created object of abstract class using lookup method injection..");
	}
}
