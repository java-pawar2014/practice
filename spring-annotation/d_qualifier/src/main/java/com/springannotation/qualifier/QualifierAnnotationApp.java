package com.springannotation.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springannotation.qualifier.bean.Motor;
import com.springannotation.qualifier.config.QualifierConfiguration;

/**
 * @author bpawar
 *
 */
public class QualifierAnnotationApp {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(QualifierConfiguration.class);

		Motor motor = applicationContext.getBean(Motor.class);
		motor.run();
	}
}
