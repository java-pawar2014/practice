package com.springcore.beanalias;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author bpawar
 *
 */
@SuppressWarnings("deprecation")
public class BeanAliasingApplication {

	public static void main(String[] args) {
		BeanFactory container = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
		System.out.println("Id:\trobot\t\t" + container.getBean("robot"));
		System.out.println("Alias:\tmachine\t\t" + container.getBean("machine"));
		System.out.println("Alias:\tachiever\t" + container.getBean("achiever")+"\n");

		String[] robotAliases = container.getAliases("robot");
		for (String alias : robotAliases) {
			System.out.println(alias);
		}
	}
}
