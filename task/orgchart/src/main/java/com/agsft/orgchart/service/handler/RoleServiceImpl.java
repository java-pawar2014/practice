package com.agsft.orgchart.service.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agsft.orgchart.data.model.Role;
import com.agsft.orgchart.data.repository.RoleRepository;
import com.agsft.orgchart.service.IRoleService;

/**
 * Implementation of {@link IRoleService}, handles all service operations of
 * {@link Role} like search, new save, existing update and removal.
 * 
 * @author bpawar
 *
 */
@Service
public class RoleServiceImpl implements IRoleService {

	private RoleRepository repository;

	/**
	 * Mandatory injection of {@link RoleRepository} to construct this.
	 * 
	 * @param repository
	 *            {@link RoleRepository} must be injected
	 */
	@Autowired
	public RoleServiceImpl(RoleRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Role findById(String id) {
		return null;
	}

	@Override
	public Role findByName(String name) {
		return null;
	}

	@Override
	public Role save(Role role) {
		return null;
	}

	@Override
	public Role update(Role role) {
		return null;
	}

	@Override
	public Boolean remove(Role role) {
		return null;
	}

	@Override
	public Boolean remove(String id) {
		return null;
	}

}
