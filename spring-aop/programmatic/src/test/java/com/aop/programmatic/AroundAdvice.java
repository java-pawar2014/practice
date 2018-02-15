package com.aop.programmatic;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;

import com.aop.programmatic.around.advice.CachingAdvice;
import com.aop.programmatic.around.advice.LogingAdvice;
import com.aop.programmatic.around.service.Calculator;
import com.aop.programmatic.util.MasterCache;
import com.aop.programmatic.util.MethodCache;

/**
 * @author bpawar
 *
 */
public class AroundAdvice {

	private ProxyFactory proxyFactory;
	private Calculator calculator;
	private LogingAdvice logingAdvice;
	private CachingAdvice cachingAdvice;
	private ApplicationContext context;

	public void run(ApplicationContext context) {
		this.context = context;

		// Around Advise executions

		// EXAMPLE 1 - Only Loging advise applied //
		exampleOne();

		// EXAMPLE 2 - Only Caching advise applied //
		exampleTwo();

		// EXAMPLE 3 - Loging and Caching advises applied //
		exampleThree();
	}

	private void exampleOne() {

		// Programmatic approached AOP without IOC container
		proxyFactory = new ProxyFactory();
		logingAdvice = new LogingAdvice();
		calculator = new Calculator();
		proxyFactory.addAdvice(logingAdvice);
		proxyFactory.setTarget(calculator);
		calculator = (Calculator) proxyFactory.getProxy();
		System.out.println("Result: " + calculator.add(50, 60) + "\n");
		proxyFactory.removeAdvice(logingAdvice);

		// Programmatic approached AOP with IOC container (XML based IOC)
		proxyFactory = context.getBean(ProxyFactory.class);
		logingAdvice = context.getBean(LogingAdvice.class);
		calculator = context.getBean(Calculator.class);
		proxyFactory.addAdvice(logingAdvice);
		proxyFactory.setTarget(calculator);
		calculator = (Calculator) proxyFactory.getProxy();
		System.out.println("Result: " + calculator.add(50, 50) + "\n");
		proxyFactory.removeAdvice(logingAdvice);

		// Pure Programmatic approached AOP with IOC container
		proxyFactory = context.getBean(ProxyFactory.class);
		logingAdvice = context.getBean(LogingAdvice.class);
		calculator = context.getBean(Calculator.class);
		proxyFactory.addAdvice(logingAdvice);
		proxyFactory.setTarget(calculator);
		calculator = (Calculator) proxyFactory.getProxy();
		System.out.println("Result: " + calculator.add(50, 60) + "\n");
		proxyFactory.removeAdvice(logingAdvice);
	}

	private void exampleTwo() {

		if (MasterCache.masterMap != null) {
			MasterCache.masterMap.clear();
		}
		if (MethodCache.methodMap != null) {
			MethodCache.methodMap.clear();
		}

		// Programmatic approached AOP without IOC container
		proxyFactory = new ProxyFactory();
		calculator = new Calculator();
		cachingAdvice = new CachingAdvice();
		proxyFactory.addAdvice(cachingAdvice);
		proxyFactory.setTarget(calculator);
		calculator = (Calculator) proxyFactory.getProxy();
		System.out.println("Result: " + (int) calculator.add(10, 20, 30) + "\n");
		System.out.println("Result: " + (int) calculator.add(10, 20, 40) + "\n");
		System.out.println("Result: " + (int) calculator.add(10, 20, 30) + "\n");
		System.out.println("Result: " + (int) calculator.multiply(10, 20) + "\n");
		System.out.println("Result: " + (int) calculator.multiply(10, 20) + "\n");
		System.out.println("Result: " + (int) calculator.multiply(10, 5) + "\n");
		proxyFactory.removeAdvice(cachingAdvice);

		// Programmatic approached AOP with IOC container (XML based IOC)
		MasterCache.masterMap.clear();
		MethodCache.methodMap.clear();

		proxyFactory = context.getBean(ProxyFactory.class);
		cachingAdvice = context.getBean(CachingAdvice.class);
		calculator = context.getBean(Calculator.class);
		proxyFactory.addAdvice(cachingAdvice);
		proxyFactory.setTarget(calculator);
		calculator = (Calculator) proxyFactory.getProxy();
		System.out.println("Result: " + (int) calculator.add(10, 20, 30) + "\n");
		System.out.println("Result: " + (int) calculator.add(10, 20, 40) + "\n");
		System.out.println("Result: " + (int) calculator.add(10, 20, 30) + "\n");
		System.out.println("Result: " + (int) calculator.multiply(10, 20) + "\n");
		System.out.println("Result: " + (int) calculator.multiply(10, 20) + "\n");
		System.out.println("Result: " + (int) calculator.multiply(10, 5) + "\n");
		proxyFactory.removeAdvice(cachingAdvice);
		// Pure Programmatic approached AOP with IOC container
		MasterCache.masterMap.clear();
		MethodCache.methodMap.clear();

		proxyFactory = context.getBean(ProxyFactory.class);
		cachingAdvice = context.getBean(CachingAdvice.class);
		calculator = context.getBean(Calculator.class);
		proxyFactory.addAdvice(cachingAdvice);
		proxyFactory.setTarget(calculator);
		calculator = (Calculator) proxyFactory.getProxy();
		System.out.println("Result: " + (int) calculator.add(10, 20, 30) + "\n");
		System.out.println("Result: " + (int) calculator.add(10, 20, 40) + "\n");
		System.out.println("Result: " + (int) calculator.add(10, 20, 30) + "\n");
		System.out.println("Result: " + (int) calculator.multiply(10, 20) + "\n");
		System.out.println("Result: " + (int) calculator.multiply(10, 20) + "\n");
		System.out.println("Result: " + (int) calculator.multiply(10, 5) + "\n");
		proxyFactory.removeAdvice(cachingAdvice);
	}

	private void exampleThree() {
		if (MasterCache.masterMap != null) {
			MasterCache.masterMap.clear();
		}
		if (MethodCache.methodMap != null) {
			MethodCache.methodMap.clear();
		}

		// Pure Programmatic approached AOP with IOC container
		proxyFactory = context.getBean(ProxyFactory.class);
		cachingAdvice = context.getBean(CachingAdvice.class);
		logingAdvice = context.getBean(LogingAdvice.class);
		calculator = context.getBean(Calculator.class);
		proxyFactory.addAdvice(cachingAdvice);
		proxyFactory.addAdvice(logingAdvice);
		proxyFactory.setTarget(calculator);
		calculator = (Calculator) proxyFactory.getProxy();
		System.out.println("Result: " + (int) calculator.add(10, 20, 30) + "\n");
		System.out.println("Result: " + (int) calculator.add(10, 20, 40) + "\n");
		System.out.println("Result: " + (int) calculator.add(10, 20, 30) + "\n");
		System.out.println("Result: " + (int) calculator.multiply(10, 20) + "\n");
		System.out.println("Result: " + (int) calculator.multiply(10, 20) + "\n");
		System.out.println("Result: " + (int) calculator.multiply(10, 5) + "\n");
		MasterCache.masterMap.clear();
		MethodCache.methodMap.clear();
		proxyFactory.removeAdvice(cachingAdvice);
		proxyFactory.removeAdvice(logingAdvice);
	}
}
