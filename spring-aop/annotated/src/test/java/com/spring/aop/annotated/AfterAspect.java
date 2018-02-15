package com.spring.aop.annotated;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.aop.annotated.after.service.KeyGenerator;

public class AfterAspect {
	private Logger logger = Logger.getLogger(AfterAspect.class);

	public void run(ApplicationContext context) {

		KeyGenerator key = context.getBean("keyGenerator", KeyGenerator.class);
		logger.info("Key: " + key.generateKey(20));
		logger.info("Key: " + key.generateKey(1));
	}
}
