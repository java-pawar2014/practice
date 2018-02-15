package com.aop.annotated.throwing.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("generalClass")
public class GeneralClass {
	private Logger logger = Logger.getLogger(GeneralClass.class);

	public void stringLength(String... args) {

		if (args.length < 2) {
			throw new ArrayIndexOutOfBoundsException(
					"Provided strings are less than expected, length is: " + args.length);
		}
		for (int i = 0; i < args.length; i++) {
			if (args[i].length() <= 2) {
				throw new StringIndexOutOfBoundsException("String length is: " + args[i].length());
			}
			logger.info("String : " + args[i]);
		}
	}
}
