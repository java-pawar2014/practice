package com.agsft.orgchart.web.model;

import java.io.Serializable;

import com.agsft.orgchart.data.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The data transfer object which interacts with service and controller on
 * behalf of {@link Role}.
 * 
 * @author bpawar
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoleDTO implements Serializable {

	private static final long serialVersionUID = 3084842242202609778L;
	/**
	 * Holds the string representation of ID of the Role
	 */
	private String _id;
	/**
	 * Holds the string representation of NAME of the Role
	 */
	private String name;

}
