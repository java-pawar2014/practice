package com.springcore.propeditor.bean;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class Payslip {

	private int employeeId;
	private String name;
	private Date paidDate;
	private File PayslipFile;
	private String[] verifiers;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public File getPayslipFile() {
		return PayslipFile;
	}

	public void setPayslipFile(File payslipFile) {
		PayslipFile = payslipFile;
	}

	public String[] getVerifiers() {
		return verifiers;
	}

	public void setVerifiers(String[] verifiers) {
		this.verifiers = verifiers;
	}

	@Override
	public String toString() {
		return "Payslip [employeeId=" + employeeId + ", name=" + name + ", paidDate=" + paidDate + ", PayslipFile="
				+ PayslipFile + ", verifiers=" + Arrays.toString(verifiers) + "]";
	}
}