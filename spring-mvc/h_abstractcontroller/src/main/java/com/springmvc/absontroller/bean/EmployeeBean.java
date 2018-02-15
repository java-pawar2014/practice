package com.springmvc.absontroller.bean;

import java.io.Serializable;

public class EmployeeBean implements Serializable {

	private static final long serialVersionUID = -864237962558847264L;

	private String employeeId;
	private String firstName;
	private String lastName;
	private String city;
	private String phone;

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCity() {
		return city;
	}

	public String getPhone() {
		return phone;
	}
}
