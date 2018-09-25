package com.agsft.orgchart.web.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.agsft.orgchart.data.model.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The data transfer object which interacts with service and controller on
 * behalf of {@link Department}.
 * 
 * @author bpawar
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO implements Serializable {

	private static final long serialVersionUID = 5189081903999676343L;

	/**
	 * Holds the string representation of ID of the Department
	 */
	private String _id;
	/**
	 * Holds the string representation of NAME of the Department
	 */
	@NotEmpty(message = "name must not be null or empty")
	private String name;
	/**
	 * Holds the number representation of TOTAL COST ASSIGNED to the Department
	 */
	private long assignedCost;
}
