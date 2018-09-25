package com.agsft.orgchart.data.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bpawar
 *
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

	private static final long serialVersionUID = 3973252435057202089L;

	private String _id;
	@Indexed(unique = true)
	private String firstName;
	private String lastName;
	@Indexed(unique = true)
	private String email;
	@Indexed(unique = true)
	private long phone;
	private Date birthDate;
	private String higherDegree;
	private int passYear;
	private int totalExperience;
	private Date joiningDate;
	private long assignedCost;
	private Role role;
	private Department department;
	private String parentEmployeeId;
	private boolean active;

}
