package com.aop.programmatic;

import org.springframework.aop.framework.ProxyFactory;

import com.aop.programmatic.after.advice.KeyValidatorAdvice;
import com.aop.programmatic.after.service.KeyGenerator;

public class AfterAdvise {

	public void run() {
		ProxyFactory proxyFactory = null;
		KeyGenerator generator = null;

		proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(new KeyGenerator());
		proxyFactory.addAdvice(new KeyValidatorAdvice());

		generator = (KeyGenerator) proxyFactory.getProxy();
		System.out.println("Generated key: " + generator.generateKey());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Generated key: " + generator.generateKey());

	}
}
