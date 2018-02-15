package com.springannotation.javaconfig;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.springannotation.javaconfig.bean.Motor;

/**
 * Java Configuration annotations: <br/>
 * 1) {@link Inject} (by Type) - equivalent to Spring {@link Autowired} <br>
 * 2) {@link Named} - equivalent to Spring {@link Qualifier} <br>
 * 3) {@link Resource} (by Name) - alternative to {@link Inject} <br>
 * 4) {@link PostConstruct} - equivalent to Spring {@link InitializingBean} <br>
 * 5) {@link PreDestroy} - equivalent to Spring {@link DisposableBean} <br>
 * 
 * @author bpawar
 *
 */
public class JavaConfigAnnoApplication {

	public static void main(String[] args) {
		AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				"com.springannotation.javaconfig.bean", "com.springannotation.javaconfig.processor");
		Motor motor = applicationContext.getBean(Motor.class);
		motor.run();

		applicationContext.registerShutdownHook();
	}
}
