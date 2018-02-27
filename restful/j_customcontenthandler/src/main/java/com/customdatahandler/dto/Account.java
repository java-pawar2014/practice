package com.customdatahandler.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.customdatahandler.annotation.KeyValuePair;

@XmlRootElement(name = "account")
@KeyValuePair
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {

	private String name;
	@XmlElement(name = "account-id")
	private String accountId;
	private String email;

	public Account() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
