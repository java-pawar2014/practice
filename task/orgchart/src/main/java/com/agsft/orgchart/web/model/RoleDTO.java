package com.agsft.orgchart.web.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author bpawar
 *
 */
@Document
public class RoleDTO implements Serializable {

	private static final long serialVersionUID = 3084842242202609778L;

	private String roleId;
	private String roleName;

	public RoleDTO() {
	}

	public RoleDTO(String roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
}