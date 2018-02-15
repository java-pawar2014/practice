package com.spring.aop.annotated;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.aop.annotated.before.service.LoanManager;
import com.aop.annotated.util.SecurityChecker;

/**
 * @author bpawar
 *
 */
public class BeforeAspect {
	private Logger logger = Logger.getLogger(BeforeAspect.class);

	public void run(ApplicationContext context) {

		SecurityChecker checker = context.getBean(SecurityChecker.class);
		checker.login("root", "root");
		LoanManager approval = context.getBean(LoanManager.class);
		boolean status = approval.approveLoan(28000, checker.getLoggedUser());
		logger.info("Loan is approved: " + status);
	}
}
