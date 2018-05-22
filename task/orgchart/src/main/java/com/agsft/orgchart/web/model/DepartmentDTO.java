package com.agsft.orgchart.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author bpawar
 *
 */
@Document
public class DepartmentDTO implements Serializable {

	private static final long serialVersionUID = 5189081903999676343L;

	private String departmentId;
	private String departmentName;
	private BigDecimal assignedCost;

	public DepartmentDTO() {
	}

	public DepartmentDTO(String departmentId, String departmentName, BigDecimal assignedCost) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.assignedCost = assignedCost;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public BigDecimal getAssignedCost() {
		return assignedCost;
	}

	public void setAssignedCost(BigDecimal assignedCost) {
		this.assignedCost = assignedCost;
	}

	

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", assignedCost="
				+ assignedCost + "]";
	}

}
