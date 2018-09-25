package com.agsft.orgchart.service.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agsft.orgchart.data.model.Role;
import com.agsft.orgchart.data.repository.IRoleRepository;
import com.agsft.orgchart.exception.DataNotFoundException;
import com.agsft.orgchart.exception.DeleteException;
import com.agsft.orgchart.exception.SaveException;
import com.agsft.orgchart.service.IRoleService;
import com.agsft.orgchart.web.model.RoleDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Implementation of {@link IRoleService}, handles all service operations of
 * {@link Role} like search, new save, existing update and removal.
 * 
 * @author bpawar
 *
 */
@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleRepository repository;
	private ObjectMapper objectMapper;

	public RoleServiceImpl() {
		this.objectMapper = new ObjectMapper();
	}

	@Override
	public List<RoleDTO> searchAll() throws DataNotFoundException {
		List<RoleDTO> roleDTOs = new ArrayList<RoleDTO>();
		List<Role> roles = repository.findAll();
		if (roles.isEmpty())
			throw new DataNotFoundException(com.agsft.orgchart.enums.ERole.NOT_FOUND.value());
		else
			for (Role role : roles)
				roleDTOs.add(objectMapper.convertValue(role, RoleDTO.class));
		return roleDTOs;
	}

	@Override
	public RoleDTO searchById(String id) throws DataNotFoundException {
		try {
			Optional<Role> optional = repository.findById(id);
			if (optional.isPresent()) {
				return objectMapper.convertValue(optional.get(), RoleDTO.class);
			} else {
				throw new DataNotFoundException("Role is not found for id " + id);
			}
		} catch (Exception cause) {
			throw new DataNotFoundException(cause.getMessage());
		}
	}

	@Override
	public RoleDTO searchByName(String name) throws DataNotFoundException {
		try {
			Optional<Role> data = repository.findByName(name);
			if (data.isPresent()) {
				return objectMapper.convertValue(data.get(), RoleDTO.class);
			} else {
				throw new DataNotFoundException("Role is not found for name " + name);
			}
		} catch (Exception cause) {
			throw new DataNotFoundException(cause.getMessage());
		}
	}

	@Override
	public RoleDTO save(RoleDTO role) throws SaveException {
		if (role.getName() == null && role.getName().isEmpty())
			throw new SaveException("Role name cannot be null or empty");
		else if (repository.existsByName(role.getName()))
			throw new SaveException("Role is already exist with name " + role.getName());
		else
			return objectMapper.convertValue(repository.insert(objectMapper.convertValue(role, Role.class)),
					RoleDTO.class);
	}

	@Override
	public List<RoleDTO> saveAll(List<RoleDTO> roles) throws SaveException {
		List<RoleDTO> savedRoles = new ArrayList<RoleDTO>();
		for (RoleDTO role : roles) {
			RoleDTO savedRole = this.save(role);
			savedRoles.add(savedRole);
		}
		return savedRoles;
	}

	@Override
	public boolean removeByName(String name) throws DeleteException {
		try {
			searchByName(name);
			repository.deleteByName(name);
			return true;
		} catch (Exception cause) {
			throw new DeleteException(cause.getMessage());
		}
	}

	@Override
	public boolean removeById(String id) throws DeleteException {
		try {
			searchById(id);
			repository.deleteById(id);
			return true;
		} catch (Exception cause) {
			throw new DeleteException(cause.getMessage());
		}
	}
}