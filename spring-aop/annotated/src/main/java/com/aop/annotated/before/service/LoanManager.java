package com.aop.annotated.before.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("loanManager")
public class LoanManager {
	private Logger logger = Logger.getLogger(LoanManager.class);

	public LoanManager() {
	}

	public boolean approveLoan(float loanAmount, String user) {
		if (loanAmount >= 10000 && loanAmount <= 1000000) {
			// System.out.println("Welcome " + user + ", your loan request is accepted.");
			logger.info("Welcome " + user + ", your loan request is accepted.");
			return true;
		} else {
			logger.info("Ohh...Sorry Mr./Miss. " + user + ", your loan request is rejected.");
			return false;
		}
	}
}
