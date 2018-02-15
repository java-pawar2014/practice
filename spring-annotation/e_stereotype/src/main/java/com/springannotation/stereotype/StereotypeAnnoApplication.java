package com.springannotation.stereotype;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springannotation.stereotype.bean.Motor;

/**
 * Stereotype annotations: <br>
 * 1) {@link Component}<br>
 * 2) {@link Repository}<br>
 * 3) {@link Service}<br>
 * 4) {@link Controller}<br>
 * 
 * @author bpawar
 *
 */
public class StereotypeAnnoApplication {

	public static void main(String[] args) {

		AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				"com.springannotation.stereotype.bean", "com.springannotation.stereotype.processor");

		Motor motor = applicationContext.getBean(Motor.class);
		motor.run();
		applicationContext.registerShutdownHook();
	}
}
