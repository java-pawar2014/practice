package com.springannotation.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springannotation.autowire.bean.Motor;
import com.springannotation.autowire.config.AutowiredConfiguration;

/**
 * @author bpawar
 *
 */
public class AutowireApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfiguration.class);

		Motor motor = applicationContext.getBean(Motor.class);
		motor.run();
	}
}
