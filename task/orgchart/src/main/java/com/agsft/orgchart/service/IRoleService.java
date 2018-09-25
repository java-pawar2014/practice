package com.agsft.orgchart.service;

import java.util.List;

import com.agsft.orgchart.exception.DataNotFoundException;
import com.agsft.orgchart.exception.DeleteException;
import com.agsft.orgchart.exception.SaveException;
import com.agsft.orgchart.web.model.RoleDTO;

/**
 * @author bpawar
 *
 */
public interface IRoleService {

	List<RoleDTO> searchAll() throws DataNotFoundException;

	RoleDTO searchById(String id) throws DataNotFoundException;

	RoleDTO searchByName(String name) throws DataNotFoundException;

	RoleDTO save(RoleDTO role) throws SaveException;

	List<RoleDTO> saveAll(List<RoleDTO> roles) throws SaveException;

	boolean removeByName(String name) throws DeleteException;

	boolean removeById(String id) throws DeleteException;

}
