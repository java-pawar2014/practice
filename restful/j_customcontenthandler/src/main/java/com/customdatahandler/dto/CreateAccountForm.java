package com.customdatahandler.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.customdatahandler.annotation.KeyValuePair;

@XmlRootElement(name = "create-account")
@KeyValuePair
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateAccountForm {

	@XmlElement(name = "first-name")
	private String firstName;
	@XmlElement(name = "last-name")
	private String lastName;
	private String gender;
	@XmlElement(name = "birth-date")
	private Date birthDate;
	private String email;
	private String password;

	public CreateAccountForm() {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
