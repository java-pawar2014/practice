package com.spring.aop.annotated;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.aop.annotated.around.service.Calculator;
import com.aop.annotated.around.service.MobileService;

public class AroundAspect {

	public void run(ApplicationContext context) {
		Logger logger = Logger.getLogger(AroundAspect.class);

		Calculator calculator = context.getBean("calculator", Calculator.class);

		logger.info("Sum: " + calculator.add(10, 20));
		/*
		 * logger.info("Sum: " + calculator.add(10, 20, 30)); logger.info("Sum: " +
		 * calculator.add(10, 20, 30, 40)); logger.info("Sub: " + calculator.sub(10,
		 * 20)); logger.info("Sub: " + calculator.sub(10, 20, 30));
		 */

		MobileService mobileService = context.getBean(MobileService.class);
		logger.info(mobileService.getMobileUserName("9960222524"));

	}
}
