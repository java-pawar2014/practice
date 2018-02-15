package com.aop.programmatic;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aop.programmatic.around.config.AroundAdviseConfig;
import com.aop.programmatic.before.config.BeforeAdviceConfig;
import com.aop.programmatic.throwing.config.ThrowingAdviceConfig;

public class AdviceTest {

	private ClassPathXmlApplicationContext context;

	@BeforeClass
	public void init() {
		AnnotationConfigApplicationContext contextParent = new AnnotationConfigApplicationContext(
				AroundAdviseConfig.class, BeforeAdviceConfig.class, ThrowingAdviceConfig.class);
		context = new ClassPathXmlApplicationContext("beans.xml");
		context.setParent(contextParent);
		context.setClassLoader(contextParent.getClassLoader());
		context.refresh();
	}

	@Test
	public void aroundAdvice() {

		new AroundAdvice().run(context);
	}

	@Test
	public void beforeAdvice() {
		new BeforeAdvice().run(context);
	}

	@Test
	public void afterAdvice() {
		new AfterAdvise().run();
	}

	@Test
	public void throwingAdvice() {
		new ThrowsAdvice().run(context);
	}

	@AfterClass
	public void destroy() {

		((ConfigurableApplicationContext) context).close();
	}
}
