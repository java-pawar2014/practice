package com.agsft.orgchart.service.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agsft.orgchart.data.model.Department;
import com.agsft.orgchart.data.repository.IDepartmentRepository;
import com.agsft.orgchart.enums.ECommonMessages;
import com.agsft.orgchart.enums.EDepartment;
import com.agsft.orgchart.exception.DataNotFoundException;
import com.agsft.orgchart.exception.DeleteException;
import com.agsft.orgchart.exception.SaveException;
import com.agsft.orgchart.exception.UpdateException;
import com.agsft.orgchart.service.IDepartmentService;
import com.agsft.orgchart.web.model.DepartmentDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Implementation of {@link IDepartmentService}, handles all service operations
 * of {@link Department} like search, new save, existing update and removal
 * 
 * @author bpawar
 *
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;
	private ObjectMapper objectMapper;

	public DepartmentServiceImpl() {
		objectMapper = new ObjectMapper();
	}

	@Override
	public List<DepartmentDTO> searchAll() throws DataNotFoundException {
		List<DepartmentDTO> departmentDTOs = new ArrayList<DepartmentDTO>();
		List<Department> departments = repository.findAll();
		if (departments.isEmpty())
			throw new DataNotFoundException(EDepartment.NOT_FOUND.value());
		else
			for (Department department : departments)
				departmentDTOs.add(objectMapper.convertValue(department, DepartmentDTO.class));
		return departmentDTOs;
	}

	@Override
	public DepartmentDTO searchById(String id) throws DataNotFoundException {
		try {
			Optional<Department> optional = repository.findById(id);
			if (optional.isPresent()) {
				return objectMapper.convertValue(optional.get(), DepartmentDTO.class);
			} else {
				throw new DataNotFoundException("Department is not found for id " + id);
			}
		} catch (Exception cause) {
			throw new DataNotFoundException(cause.getMessage());
		}
	}

	@Override
	public DepartmentDTO searchByName(String name) throws DataNotFoundException {
		try {
			Optional<Department> data = repository.findByName(name);
			if (data.isPresent()) {
				return objectMapper.convertValue(data.get(), DepartmentDTO.class);
			} else {
				throw new DataNotFoundException("Department not found for name " + name);
			}
		} catch (Exception cause) {
			throw new DataNotFoundException(cause.getMessage());
		}
	}

	@Override
	public DepartmentDTO save(DepartmentDTO department) throws SaveException {
		if (department.getName() == null && !department.getName().isEmpty())
			throw new SaveException("Department name cannot be null or empty");
		else {
			if (repository.existsByName(department.getName()))
				throw new SaveException("Department is exist with name " + department.getName());
			else
				return objectMapper.convertValue(
						repository.insert(objectMapper.convertValue(department, Department.class)),
						DepartmentDTO.class);
		}
	}

	@Override
	public List<DepartmentDTO> saveAll(List<DepartmentDTO> departments) throws SaveException {
		List<DepartmentDTO> savedDepartments = new ArrayList<DepartmentDTO>();
		for (DepartmentDTO department : departments) {
			DepartmentDTO savedDepartment = this.save(department);
			savedDepartments.add(savedDepartment);
		}
		return savedDepartments;
	}

	@Override
	public DepartmentDTO update(DepartmentDTO department) throws UpdateException, SaveException {

		if (department.get_id() == null || department.get_id().isEmpty()) {
			throw new RuntimeException(ECommonMessages.ID_NOT_NULL_EMPTY.message());
		} else {
			if (repository.existsById(department.get_id())) {
				Optional<Department> departmentData = repository.findById(department.get_id());
				Department updateDepartment = departmentData.get();
				if (!department.getName().equalsIgnoreCase(updateDepartment.getName())) {
					throw new UpdateException("Cannot update department name");
				} else {
					updateDepartment.setAssignedCost(department.getAssignedCost());
					return objectMapper.convertValue(repository.save(updateDepartment), DepartmentDTO.class);
				}
			} else {
				throw new SaveException();
			}
		}
	}

	@Override
	public boolean removeByName(String name) throws DeleteException {
		try {
			DepartmentDTO departmentToDelete = searchByName(name);
			repository.delete(objectMapper.convertValue(departmentToDelete, Department.class));
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
