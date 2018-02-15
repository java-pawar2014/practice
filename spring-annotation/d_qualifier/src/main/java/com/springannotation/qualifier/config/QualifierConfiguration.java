package com.springannotation.qualifier.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springannotation.qualifier.bean.Engine;
import com.springannotation.qualifier.bean.Motor;

/**
 * @author bpawar
 *
 */
@Configuration
public class QualifierConfiguration {

	@Bean(name = "engine")
	@Qualifier(value = "engine1")
	public Engine engine() {
		return new Engine("ENG6655481", "DIESEL");
	}

	@Bean
	public Motor motor() {
		return new Motor();
	}
}
