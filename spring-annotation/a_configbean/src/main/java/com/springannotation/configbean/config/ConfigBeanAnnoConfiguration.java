package com.springannotation.configbean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springannotation.configbean.service.DummyService;

/**
 * @author bpawar
 *
 */
@Configuration
public class ConfigBeanAnnoConfiguration {

	@Bean
	public DummyService dummyService() {
		return new DummyService();
	}
}
