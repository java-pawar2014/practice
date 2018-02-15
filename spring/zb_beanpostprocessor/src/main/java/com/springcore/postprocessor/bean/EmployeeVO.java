package com.springcore.postprocessor.bean;

import java.io.Serializable;

public class EmployeeVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = -5700303239535577956L;

	private String employeeId;
	private String name;
	private float salary;

	public EmployeeVO() {
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
}
