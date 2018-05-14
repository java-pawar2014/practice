package com.springboot.mongodb.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 5819194652530208180L;

	// @Id
	private String _id;
	@NotNull(message = "FIRST NAME SHOULD NOT BE NULL")
	private String firstName;
	@NotNull(message = "LAST NAME SHOULD NOT BE NULL")
	private String lastName;

	private boolean active;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
