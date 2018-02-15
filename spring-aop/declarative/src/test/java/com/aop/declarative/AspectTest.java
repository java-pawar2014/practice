package com.aop.declarative;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aop.declarative.after.bean.KeyGenerator;
import com.aop.declarative.around.bean.Calculator;
import com.aop.declarative.before.service.LoanApproval;
import com.aop.declarative.throwing.bean.GeneralClass;
import com.aop.declarative.util.SecurityChecker;

/**
 * @author bpawar
 *
 */
public class AspectTest {

	private Logger logger = Logger.getLogger(AspectTest.class);

	private ApplicationContext context;

	@BeforeClass
	public void init() {

		context = new ClassPathXmlApplicationContext("beans.xml");
	}

	@Test
	public void aroundAspect() {

		Calculator calculator = context.getBean("calculator", Calculator.class);
		logger.info("Sum: " + calculator.add(20, 30));
		logger.info("Around Aspect completed.\n");
	}

	@Test
	public void afterAspect() {
		KeyGenerator key = context.getBean("keyGenerator", KeyGenerator.class);
		logger.info("Key: " + key.generateKey(20));
		logger.info("Key: " + key.generateKey(30));
		logger.info("After Aspect completed.\n");
	}

	@Test
	public void beforeAspect() {

		SecurityChecker checker = context.getBean("securityChecker", SecurityChecker.class);
		checker.login("root", "root");
		LoanApproval approval = context.getBean("loanApproval", LoanApproval.class);
		boolean status = approval.approveLoan(28000, checker.getLoggedUser());
		logger.info("Loan is approved: " + status);
		logger.info("Before Aspect completed.\n");
	}

	@Test
	public void throwingAspect() {

		GeneralClass clazz = context.getBean("generalClass", GeneralClass.class);
		clazz.stringLength("abasdas", "de");
		logger.info("Throwing Aspect completed.\n");
	}

	@AfterClass
	public void destroy() {
		if (context != null)
			((ConfigurableApplicationContext) context).close();
	}
}
