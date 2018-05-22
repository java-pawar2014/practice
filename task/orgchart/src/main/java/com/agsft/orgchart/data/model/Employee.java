package com.agsft.orgchart.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author bpawar
 *
 */
@Document
public class Employee implements Serializable {

	private static final long serialVersionUID = 3973252435057202089L;

	private String _id;
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private Date birthDate;
	private String higherDegree;
	private Integer passYear;
	private Integer totalExperience;
	private Date joiningDate;
	private BigDecimal assignedCost;
	private Role role;
	private Department department;
	private String parentEmployeeId;
	private boolean active;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getHigherDegree() {
		return higherDegree;
	}

	public void setHigherDegree(String higherDegree) {
		this.higherDegree = higherDegree;
	}

	public Integer getPassYear() {
		return passYear;
	}

	public void setPassYear(Integer passYear) {
		this.passYear = passYear;
	}

	public Integer getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(Integer totalExperience) {
		this.totalExperience = totalExperience;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public BigDecimal getAssignedCost() {
		return assignedCost;
	}

	public void setAssignedCost(BigDecimal assignedCost) {
		this.assignedCost = assignedCost;
	}

	public String getParentEmployeeId() {
		return parentEmployeeId;
	}

	public void setParentEmployeeId(String parentEmployeeId) {
		this.parentEmployeeId = parentEmployeeId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Employee [_id=" + _id + ", employeeId=" + employeeId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phone=" + phone + ", birthDate=" + birthDate + ", higherDegree="
				+ higherDegree + ", passYear=" + passYear + ", totalExperience=" + totalExperience + ", joiningDate="
				+ joiningDate + ", assignedCost=" + assignedCost + ", role=" + role + ", department=" + department
				+ ", parentEmployeeId=" + parentEmployeeId + ", active=" + active + "]";
	}

}
