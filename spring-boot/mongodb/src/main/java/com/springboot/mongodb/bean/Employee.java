package com.springboot.mongodb.bean;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee implements Serializable {

	private static final long serialVersionUID = 3493768983308474802L;

	private String _id;
	@NotNull(message = "First Name cannot be null")
	@NotBlank(message = "First Name cannot be blank")
	@NotEmpty(message = "First Name cannot be empty")
	@Size(min = 1, max = 20, message = "First Name must be of character size between 1 to 20")
	private String firstName;

	@NotNull(message = "Last Name cannot be null")
	@NotBlank(message = "Last Name cannot be blank")
	@NotEmpty(message = "Last Name cannot be empty")
	@Size(min = 1, max = 20, message = "Last Name must be of character size between 1 to 20")
	private String lastName;

	@Positive(message = "Age must be positive number starts from 18")
	@Min(value = 18, message = "Age must be equal or greater than 18")
	@Max(value = 65, message = "Age must be equal or less than 65")
	private Integer age;

	private Boolean active;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}