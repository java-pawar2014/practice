package com.agsft.orgchart.service.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agsft.orgchart.data.model.Department;
import com.agsft.orgchart.data.model.Employee;
import com.agsft.orgchart.data.model.Role;
import com.agsft.orgchart.data.repository.IDepartmentRepository;
import com.agsft.orgchart.data.repository.IEmployeeRepository;
import com.agsft.orgchart.data.repository.IRoleRepository;
import com.agsft.orgchart.enums.ECommonMessages;
import com.agsft.orgchart.exception.DataNotFoundException;
import com.agsft.orgchart.exception.DeleteException;
import com.agsft.orgchart.exception.SaveException;
import com.agsft.orgchart.exception.UpdateException;
import com.agsft.orgchart.service.IEmployeeService;
import com.agsft.orgchart.web.model.EmployeeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Implementation of {@link IEmployeeService}, handles all service operations of
 * {@link Employee} like search, new save, existing update and removal
 * 
 * @author bpawar
 *
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;
	@Autowired
	private IRoleRepository roleRepository;
	@Autowired
	private IDepartmentRepository departmentRepository;

	private ObjectMapper objectMapper;

	public EmployeeServiceImpl() {
		this.objectMapper = new ObjectMapper();
	}

	@Override
	public EmployeeDTO searchById(String id) throws DataNotFoundException {
		try {
			if (employeeRepository.existsById(id))
				return objectMapper.convertValue(employeeRepository.findById(id).get(), EmployeeDTO.class);
			else
				throw new DataNotFoundException("Employee is not found for id " + id);
		} catch (Exception cause) {
			throw new DataNotFoundException(cause.getMessage());
		}
	}

	@Override
	public EmployeeDTO searchByEmail(String email) throws DataNotFoundException {
		try {
			if (employeeRepository.existsByEmail(email))
				return objectMapper.convertValue(employeeRepository.findByEmail(email).get(), EmployeeDTO.class);
			else
				throw new DataNotFoundException("Employee is not found for email " + email);
		} catch (Exception cause) {
			throw new DataNotFoundException(cause.getMessage());
		}
	}

	@Override
	public List<EmployeeDTO> searchAll() throws DataNotFoundException {
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		List<Employee> employees = employeeRepository.findAll();
		if (employees.isEmpty())
			throw new DataNotFoundException("Employee(s) not found");
		else
			for (Employee employee : employees)
				employeeDTOs.add(objectMapper.convertValue(employee, EmployeeDTO.class));
		return employeeDTOs;
	}

	@Override
	public EmployeeDTO save(EmployeeDTO employee) throws SaveException {
		Role newRole = null;
		Department newDepartment = null;
		if (employeeRepository.existsByEmail(employee.getEmail()))
			throw new SaveException("Employee is already exist with email " + employee.getEmail());
		else {
			Role role = objectMapper.convertValue(employee.getRole(), Role.class);
			if (role != null)
				if (role.getName() != null && !role.getName().isEmpty())
					if (roleRepository.existsByName(role.getName()))
						newRole = roleRepository.findByName(role.getName()).get();
					else
						newRole = roleRepository.save(new Role(null, role.getName()));
			Department department = objectMapper.convertValue(employee.getDepartment(), Department.class);
			if (department != null)
				if (department.getName() != null && !department.getName().isEmpty())
					if (departmentRepository.existsByName(department.getName()))
						newDepartment = departmentRepository.findByName(department.getName()).get();
					else
						newDepartment = departmentRepository
								.save(new Department(null, department.getName(), department.getAssignedCost()));
			Employee employeeToInsert = objectMapper.convertValue(employee, Employee.class);
			employeeToInsert.setRole(newRole);
			employeeToInsert.setDepartment(newDepartment);
			return objectMapper.convertValue(employeeRepository.insert(employeeToInsert), EmployeeDTO.class);
		}
	}

	@Override
	public List<EmployeeDTO> saveAll(List<EmployeeDTO> employees) throws SaveException {
		List<EmployeeDTO> savedEmployees = new ArrayList<EmployeeDTO>();
		if (employees != null && !employees.isEmpty())
			for (EmployeeDTO employee : employees)
				savedEmployees.add(this.save(employee));
		else
			throw new SaveException("Unable to save empty list of employee");
		return savedEmployees;
	}

	@Override
	public EmployeeDTO update(EmployeeDTO employee) throws SaveException, UpdateException {
		Role newRole = null;
		Department newDepartment = null;

		if (employee.get_id() == null || employee.get_id().isEmpty())
			throw new RuntimeException(ECommonMessages.ID_NOT_NULL_EMPTY.message());
		else {
			if (employeeRepository.existsById(employee.get_id())) {
				Optional<Employee> employeeData = employeeRepository.findById(employee.get_id());
				Employee updateEmployee = employeeData.get();
				if (!employee.getEmail().equalsIgnoreCase(updateEmployee.getEmail()))
					throw new UpdateException("Cannot update employee email");
				else {
					Role role = objectMapper.convertValue(employee.getRole(), Role.class);
					if (role != null)
						if (role.getName() != null && !role.getName().isEmpty())
							if (roleRepository.existsByName(role.getName()))
								newRole = roleRepository.findByName(role.getName()).get();
							else
								newRole = roleRepository.save(new Role(null, role.getName()));
					Department department = objectMapper.convertValue(employee.getDepartment(), Department.class);
					if (department != null)
						if (department.getName() != null && !department.getName().isEmpty())
							if (departmentRepository.existsByName(department.getName()))
								newDepartment = departmentRepository.findByName(department.getName()).get();
							else
								newDepartment = departmentRepository
										.save(new Department(null, department.getName(), department.getAssignedCost()));
					updateEmployee = objectMapper.convertValue(employee, Employee.class);
					updateEmployee.setRole(newRole);
					updateEmployee.setDepartment(newDepartment);
					return objectMapper.convertValue(employeeRepository.save(updateEmployee), EmployeeDTO.class);
				}
			} else
				return save(employee);
		}
	}

	@Override
	public boolean removeByEmail(String email) throws DeleteException {
		try {
			if (employeeRepository.existsByEmail(email))
				employeeRepository.deleteByEmail(email);
			else
				throw new DataNotFoundException("Employee is not found for email " + email);
			return true;
		} catch (Exception cause) {
			throw new DeleteException(cause.getMessage());
		}
	}

	@Override
	public boolean removeById(String id) throws DeleteException {
		try {
			searchById(id);
			employeeRepository.deleteById(id);
			return true;
		} catch (Exception cause) {
			throw new DeleteException(cause.getMessage());
		}
	}
}
