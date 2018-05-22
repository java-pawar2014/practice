package com.agsft.orgchart.service;

import com.agsft.orgchart.data.model.Role;

/**
 * @author bpawar
 *
 */
public interface IRoleService {

	Role findById(String id);

	Role findByName(String name);

	Role save(Role role);

	Role update(Role role);

	Boolean remove(Role role);

	Boolean remove(String id);

}
