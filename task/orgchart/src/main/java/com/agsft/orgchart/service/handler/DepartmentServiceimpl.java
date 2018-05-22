package com.agsft.orgchart.service.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agsft.orgchart.data.model.Department;
import com.agsft.orgchart.data.repository.DepartmentRepository;
import com.agsft.orgchart.service.IDepartmentService;

/**
 * Implementation of {@link IDepartmentService}, handles all service operations
 * of {@link Department} like search, new save, existing update and removal
 * 
 * @author bpawar
 *
 */
@Service
public class DepartmentServiceimpl implements IDepartmentService {

	private DepartmentRepository repository;

	/**
	 * Mandatory injection of {@link DepartmentRepository} to construct this.
	 * 
	 * @param repository
	 *            {@link DepartmentRepository} must be injected
	 */
	@Autowired
	public DepartmentServiceimpl(DepartmentRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Department findById(String id) {
		return null;
	}

	@Override
	public Department findByName(String name) {
		return null;
	}

	@Override
	public Department save(Department department) {
		return null;
	}

	@Override
	public Department update(Department department) {
		return null;
	}

	@Override
	public Boolean remove(Department department) {
		return null;
	}

	@Override
	public Boolean remove(String id) {
		return null;
	}

}
