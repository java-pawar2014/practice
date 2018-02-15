package com.aop.programmatic.around.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aop.programmatic.around.service.Calculator;

/**
 * @author bpawar
 *
 */
@Configuration
public class AroundAdviseConfig {

	@Bean
	public Calculator calculator() {
		return new Calculator();
	}
}
