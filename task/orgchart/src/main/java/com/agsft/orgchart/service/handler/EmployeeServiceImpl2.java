/*package com.agsft.orgchart.service.handler;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agsft.orgchart.data.model.Department;
import com.agsft.orgchart.data.model.Employee;
import com.agsft.orgchart.data.model.Role;
import com.agsft.orgchart.data.repository.IDepartmentRepository;
import com.agsft.orgchart.data.repository.IEmployeeRepository;
import com.agsft.orgchart.data.repository.IRoleRepository;
import com.agsft.orgchart.enums.ColumnHeader;
import com.agsft.orgchart.enums.CommonMessages;
import com.agsft.orgchart.service.IEmployeeService;
import com.agsft.orgchart.util.Reader;
import com.agsft.orgchart.web.model.EmployeeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

*//**
 * Implementation of {@link IEmployeeService}, handles all service operations of
 * {@link Employee} like search, new save, existing update and removal.
 * 
 * @author bpawar
 *
 *//*
@Service
public class EmployeeServiceImpl2 implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;
	@Autowired
	private IRoleRepository roleRepository;
	@Autowired
	private IDepartmentRepository departmentRepository;

	private ObjectMapper objectMapper;
	private SimpleDateFormat dateFormat;

	public EmployeeServiceImpl2() {
		this.objectMapper = new ObjectMapper();
		this.dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	}

	@Override
	public EmployeeDTO findById(String id) throws IllegalArgumentException {
		EmployeeDTO employee = null;
		if (id != null && !id.isEmpty()) {
			if (employeeRepository.existsById(id)) {
				Optional<Employee> data = employeeRepository.findById(id);
				if (data.isPresent())
					employee = objectMapper.convertValue(data.get(), EmployeeDTO.class);
			}
		} else {
			throw new IllegalArgumentException(CommonMessages.ID_NOT_NULL_EMPTY.message());
		}
		return employee;
	}

	@Override
	public List<EmployeeDTO> findAll() {
		List<EmployeeDTO> employeeDtos = null;
		List<Employee> employees = null;
		employees = employeeRepository.findAll();
		employeeDtos = new ArrayList<EmployeeDTO>();
		if (employees.isEmpty())
			return employeeDtos;
		else {
			for (Employee employee : employees) {
				if (employee != null) {
					if (employee.isActive()) {
						EmployeeDTO dto = objectMapper.convertValue(employee, EmployeeDTO.class);
						employeeDtos.add(dto);
					}
				}
			}
		}
		return employeeDtos;
	}

	@Override
	public EmployeeDTO save(EmployeeDTO employee) throws IllegalArgumentException {
		if (employee != null) {
			return objectMapper.convertValue(
					employeeRepository.save(objectMapper.convertValue(employee, Employee.class)), EmployeeDTO.class);
		} else {
			throw new IllegalArgumentException(CommonMessages.PARAM_NOT_NULL_EMPTY.message());
		}
	}

	@Override
	public EmployeeDTO update(EmployeeDTO employee) {
		if (employee != null) {
			if (employee.get_id() != null && !employee.get_id().isEmpty()) {
				if (employeeRepository.existsById(employee.get_id())) {
					Optional<Employee> data = employeeRepository.findById(employee.get_id());
					if (data.isPresent()) {
						Employee employeeToUpdate = data.get();
						employeeToUpdate.setActive(employee.isActive());
						employeeToUpdate.setAssignedCost(employee.getAssignedCost());
						employeeToUpdate.setBirthDate(employee.getBirthDate());
						employeeToUpdate
								.setDepartment(objectMapper.convertValue(employee.getDepartment(), Department.class));
						employeeToUpdate.setEmail(employee.getEmail());
						// employeeToUpdate.setEmployeeId(employee.getEmployeeId());
						employeeToUpdate.setFirstName(employee.getFirstName());
						employeeToUpdate.setLastName(employee.getLastName());
						employeeToUpdate.setHigherDegree(employee.getHigherDegree());
						employeeToUpdate.setJoiningDate(employee.getJoiningDate());
						employeeToUpdate.setParentEmployeeId(employee.getParentEmployeeId());
						employeeToUpdate.setPassYear(employee.getPassYear());
						employeeToUpdate.setPhone(employee.getPhone());
						employeeToUpdate.setRole(objectMapper.convertValue(employee.getRole(), Role.class));
						employeeToUpdate.setTotalExperience(employee.getTotalExperience());
						return objectMapper.convertValue(employeeRepository.save(employeeToUpdate), EmployeeDTO.class);
					}
				}
			} else {
				throw new IllegalArgumentException(CommonMessages.ID_NOT_NULL_EMPTY.message());
			}
		} else {
			throw new IllegalArgumentException(CommonMessages.PARAM_NOT_NULL_EMPTY.message());
		}
		return null;
	}

	@Override
	public boolean removeByName(EmployeeDTO employee) {

		if (employeeRepository.existsById(employee.get_id())) {
			Optional<Employee> data = employeeRepository.findById(employee.get_id());
			if (data.isPresent()) {
				Employee employeeToUpdate = data.get();
				employeeToUpdate.setActive(false);
				employeeRepository.save(employeeToUpdate);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeById(String id) {

		if (employeeRepository.existsById(id)) {
			Optional<Employee> data = employeeRepository.findById(id);
			if (data.isPresent()) {
				Employee employeeToUpdate = data.get();
				employeeToUpdate.setActive(false);
				employeeRepository.save(employeeToUpdate);
				return true;
			}
		}

		return false;
	}
	
	
	
}
*/