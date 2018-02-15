package com.springannotation.configbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springannotation.configbean.config.ConfigBeanAnnoConfiguration;
import com.springannotation.configbean.service.DummyService;

/**
 * @author bpawar
 *
 */
public class ConfigBeanAnnotationApp {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				new Class<?>[] { ConfigBeanAnnoConfiguration.class });

		DummyService service = applicationContext.getBean(DummyService.class);
		service.sampleCode();
	}
}