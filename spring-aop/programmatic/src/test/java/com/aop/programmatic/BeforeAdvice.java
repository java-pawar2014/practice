package com.aop.programmatic;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;

import com.aop.programmatic.before.advice.AccessAdvice;
import com.aop.programmatic.before.advice.SecurityCheckAdvice;
import com.aop.programmatic.before.service.LoanManager;
import com.aop.programmatic.util.SecurityChecker;

/**
 * @author bpawar
 *
 */
public class BeforeAdvice {

	public void run(ApplicationContext context) {

		// Before Advise executions //

		ProxyFactory proxyFactory = null;
		LoanManager loanManager = null;
		AccessAdvice accessAdvice = null;
		SecurityChecker securityChecker = null;
		SecurityCheckAdvice securityCheckAdvice = null;

		// EXAMPLE 1 //
		// Programmatic AOP without IOC container //
		proxyFactory = new ProxyFactory();
		loanManager = new LoanManager();
		accessAdvice = new AccessAdvice();
		proxyFactory.setTarget(loanManager);
		proxyFactory.addAdvice(accessAdvice);

		loanManager = (LoanManager) proxyFactory.getProxy();
		loanManager.approveLoan(225352.5f, "Pawar");
		loanManager.approveLoan(352.5f, "Bhosale");
		proxyFactory.removeAdvice(accessAdvice);

		// EXAMPLE 2 //
		// Pure Programmatic AOP with IOC container //
		loanManager = context.getBean(LoanManager.class);
		securityChecker = context.getBean(SecurityChecker.class);
		securityCheckAdvice = context.getBean(SecurityCheckAdvice.class);
		proxyFactory = context.getBean(ProxyFactory.class);
		proxyFactory.setTarget(loanManager);
		proxyFactory.addAdvice(securityCheckAdvice);

		securityChecker.login("root", "root");
		loanManager = (LoanManager) proxyFactory.getProxy();
		loanManager.approveLoan(100000, "root");
		loanManager.approveLoan(1000, "root");
		proxyFactory.removeAdvice(securityCheckAdvice);
	}
}
