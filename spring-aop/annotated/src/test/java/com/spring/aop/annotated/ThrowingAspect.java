package com.spring.aop.annotated;

import org.springframework.context.ApplicationContext;

import com.aop.annotated.throwing.service.GeneralClass;

public class ThrowingAspect {

	public void run(ApplicationContext context) {

		GeneralClass clazz = context.getBean(GeneralClass.class);
		clazz.stringLength("abasdas", "ab");
	}
}
