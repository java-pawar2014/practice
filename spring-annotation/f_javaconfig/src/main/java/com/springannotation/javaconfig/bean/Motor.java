package com.springannotation.javaconfig.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

/**
 * @author bpawar
 *
 */
@SuppressWarnings("unused")
@Component
public class Motor {

	private Engine engine;

	public void run() {
		System.out.println("Starting motor with engine : " + engine);
	}

	// @Inject
	@Resource
	@Named(value = "motor1")
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Injection of engine : " + engine + " is completed.");
		System.out.println("Modifying engine...");
		engine.setEngineSerial("ENG33215141");
		engine.setEngineType("CNG");
	}

	@PreDestroy
	public void destroy() {
		engine = null;
		System.out.println("Stopping motor and engine set to: " + engine);
	}
}