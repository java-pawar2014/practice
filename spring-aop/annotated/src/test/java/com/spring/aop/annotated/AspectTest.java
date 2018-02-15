package com.spring.aop.annotated;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aop.annotated.config.AnnotatedConfig;

public class AspectTest {

	private ApplicationContext context;

	@BeforeClass
	public void beforeClass() {
		/** Mixed configuration: anootation + xml based bean scan */
		// context = new ClassPathXmlApplicationContext("beans.xml");

		/** Pure annotated configuration */
		context = new AnnotationConfigApplicationContext(AnnotatedConfig.class);

	}

	@Test(enabled = false)
	public void beforeAspect() {

		new BeforeAspect().run(this.context);
	}

	@Test
	public void afterAspect() {

		new AfterAspect().run(this.context);
	}

	@Test(enabled = false)
	public void aroundAspect() {

		new AroundAspect().run(this.context);
	}

	@Test
	public void throwingAspect() {

		new ThrowingAspect().run(this.context);
	}

	@AfterClass(enabled = false)
	public void afterClass() {

		((ConfigurableApplicationContext) this.context).close();
	}

}
