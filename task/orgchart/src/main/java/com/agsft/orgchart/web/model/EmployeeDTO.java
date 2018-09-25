package com.agsft.orgchart.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;

import org.springframework.data.mongodb.core.mapping.Document;

import com.agsft.orgchart.data.model.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The data transfer object which interacts with service and controller on
 * behalf of {@link Employee}.
 * 
 * @author bpawar
 *
 */

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = 3973252435057202089L;
	/**
	 * Holds the string representation of ID of the Employee
	 */
	private String _id;
	/**
	 * Holds the string representation of FIRST NAME of the Employee
	 */
	private String firstName;
	/**
	 * Holds the string representation of LAST NAME of the Employee
	 */
	private String lastName;
	/**
	 * Holds the string representation of EMAIL of the Employee
	 */
	@Email()
	private String email;
	/**
	 * Holds the number representation of PHONE NUMBER of the Employee
	 */
	private long phone;
	/**
	 * Holds the date/time representation of BIRTH DATE of the Employee
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	/**
	 * Holds the string representation of HIGHER DEGREE of the Employee
	 */
	private String higherDegree;
	/**
	 * Holds the number representation of PASS YEAR of the Employee
	 */
	private int passYear;
	/**
	 * Holds the number representation of TOTAL EXPERIENCE of the Employee
	 */
	private int totalExperience;
	/**
	 * Holds the date/time representation of JOINING DATE of the Employee
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date joiningDate;
	/**
	 * Holds the number representation of TOTAL COST ASSIGNED to the Employee
	 */
	private long assignedCost;
	/**
	 * Holds the {@link RoleDTO} object
	 */
	private RoleDTO role;
	/**
	 * Holds the {@link DepartmentDTO}
	 */
	private DepartmentDTO department;
	/**
	 * Holds the string representation of PARENT ID of the Employee
	 */
	private String parentEmployeeId;
	/**
	 * Holds the boolean representation for ACTIVE status of the Employee
	 */
	private boolean active;

}
