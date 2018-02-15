package com.springannotation.autowire.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springannotation.autowire.bean.Engine;
import com.springannotation.autowire.bean.Motor;

@Configuration
public class AutowiredConfiguration {

	@Bean(name = "engine", autowire = Autowire.BY_TYPE)
	// @Scope(value = "prototype")
	public Engine engine() {
		return new Engine("ENG878887", "DIESEL");
	}

	@Bean(name = "motor")
	public Motor motor(Engine engine) {
		return new Motor(engine);
	}
}