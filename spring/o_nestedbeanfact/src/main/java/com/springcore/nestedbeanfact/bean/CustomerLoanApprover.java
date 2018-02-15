package com.springcore.nestedbeanfact.bean;

/**
 * @author bpawar
 *
 */
public class CustomerLoanApprover {

	private EmiCalculator emiCalculator;

	public void approve(double grossSalary, long principalAmt, int tenure) {
		float emi = emiCalculator.compute(principalAmt, 12.5f, tenure);
		System.out.println("EMI: " + emi);
		if (emi > 0) {
			System.out.println("Approved...!");
		} else {
			System.out.println("Rejected...!");
		}
	}

	public EmiCalculator getEmiCalculator() {
		return emiCalculator;
	}

	public void setEmiCalculator(EmiCalculator emiCalculator) {
		this.emiCalculator = emiCalculator;
	}
}
