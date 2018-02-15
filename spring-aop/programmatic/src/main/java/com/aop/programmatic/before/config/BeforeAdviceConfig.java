package com.aop.programmatic.before.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aop.programmatic.before.advice.SecurityCheckAdvice;
import com.aop.programmatic.before.service.LoanManager;
import com.aop.programmatic.util.SecurityChecker;

/**
 * @author bpawar
 *
 */
@Configuration
public class BeforeAdviceConfig {

	@Bean
	public LoanManager loanManager() {
		return new LoanManager();
	}

	@Bean
	public SecurityChecker securityChecker() {
		return new SecurityChecker();
	}

	@Bean
	@Autowired
	public SecurityCheckAdvice securityCheckAdvice(SecurityChecker securityChecker) {
		SecurityCheckAdvice securityCheckAdvice = new SecurityCheckAdvice();
		securityCheckAdvice.setSecurityChecker(securityChecker);
		return securityCheckAdvice;
	}
}
