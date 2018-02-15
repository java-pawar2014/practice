package com.springannotation.required;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springannotation.required.bean.Engine;

/**
 * @author bpawar
 *
 */
public class RequiredAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		System.out.println(applicationContext.getBean(Engine.class));
	}
}
