package com.aop.programmatic.before.service;

/**
 * @author bpawar
 *
 */
public class LoanManager {

	public boolean approveLoan(float loanAmount, String user) {

		if (loanAmount > 10000 && loanAmount < 1000000) {
			System.out.println("Welcome " + user + ", your loan request is accepted.");
			return true;
		} else {
			System.out.println("Ohh...Sorry " + user + ", your loan request is rejected.");
			return false;
		}
	}
}
