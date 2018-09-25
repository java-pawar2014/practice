/**
 * 
 */
package com.agsft.droolinsurance.model;

import java.util.Date;

/**
 * @author bpawar
 * @since 13-Aug-2018
 */
public class Person {

	private long id;
	private String name;
	private Date birthDate;
	private String address;
	private String contact;

	public Person() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", address=" + address
				+ ", contact=" + contact + "]";
	}

}
