package com.springmvc.abscmd.bean;

import java.io.Serializable;

/**
 * @author bpawar
 *
 */
public class Employee implements Serializable {

	private static final long serialVersionUID = 28580648455010702L;

	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String contact;
	private String city;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}