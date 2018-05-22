package com.agsft.orgchart.service.handler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agsft.orgchart.data.model.Department;
import com.agsft.orgchart.data.model.Employee;
import com.agsft.orgchart.data.model.Role;
import com.agsft.orgchart.data.repository.DepartmentRepository;
import com.agsft.orgchart.data.repository.EmployeeRepository;
import com.agsft.orgchart.data.repository.RoleRepository;
import com.agsft.orgchart.enums.CommonMessages;
import com.agsft.orgchart.service.IEmployeeService;
import com.agsft.orgchart.util.Reader;
import com.agsft.orgchart.web.model.EmployeeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Implementation of {@link IEmployeeService}, handles all service operations of
 * {@link Employee} like search, new save, existing update and removal.
 * 
 * @author bpawar
 *
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private Reader reader;
	private ObjectMapper objectMapper;

	/**
	 * Mandatory injection of {@link EmployeeRepository} to construct this.
	 * 
	 * @param repository
	 *            {@link EmployeeRepository} must be injected
	 */
	public EmployeeServiceImpl() {
		this.objectMapper = new ObjectMapper();
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
			throw new IllegalArgumentException(CommonMessages.PARAM_NOT_NULL.message());
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
						employeeToUpdate.setAssignedCost(employee.getAssignedCost());
						employeeToUpdate.setBirthDate(employee.getBirthDate());
						employeeToUpdate.setParentEmployeeId(employee.getParentEmployeeId());
						employeeToUpdate
								.setDepartment(objectMapper.convertValue(employee.getDepartment(), Department.class));
						employeeToUpdate.setEmail(employee.getEmail());
						employeeToUpdate.setEmployeeId(employee.getEmployeeId());
						employeeToUpdate.setFirstName(employee.getFirstName());
						employeeToUpdate.setLastName(employee.getLastName());
						employeeToUpdate.setHigherDegree(employee.getHigherDegree());
						employeeToUpdate.setJoiningDate(employee.getJoiningDate());
						employeeToUpdate.setPassYear(employee.getPassYear());
						employeeToUpdate.setPhone(employee.getPhone());
						employeeToUpdate.setRole(objectMapper.convertValue(employee.getRole(), Role.class));
						employeeToUpdate.setTotalExperience(employee.getTotalExperience());
						employeeToUpdate.setActive(employee.isActive());
						return objectMapper.convertValue(employeeRepository.save(employeeToUpdate), EmployeeDTO.class);
					}
				}
			} else {
				throw new IllegalArgumentException(CommonMessages.ID_NOT_NULL_EMPTY.message());
			}
		} else {
			throw new IllegalArgumentException(CommonMessages.PARAM_NOT_NULL.message());
		}
		return null;
	}

	@Override
	public Boolean remove(EmployeeDTO employee) {

		if (employee != null) {
			if (employee.get_id() != null && !employee.get_id().isEmpty()) {
				if (employeeRepository.existsById(employee.get_id())) {
					Optional<Employee> data = employeeRepository.findById(employee.get_id());
					if (data.isPresent()) {
						Employee employeeToUpdate = data.get();
						employeeToUpdate.setActive(false);
						employeeRepository.save(employeeToUpdate);
						return true;
					}
				}
			} else {
				throw new IllegalArgumentException(CommonMessages.ID_NOT_NULL_EMPTY.message());
			}
		} else {
			throw new IllegalArgumentException(CommonMessages.PARAM_NOT_NULL.message());
		}
		return false;
	}

	@Override
	public Boolean remove(String id) {
		if (id != null && !id.isEmpty()) {
			if (employeeRepository.existsById(id)) {
				Optional<Employee> data = employeeRepository.findById(id);
				if (data.isPresent()) {
					Employee employeeToUpdate = data.get();
					employeeToUpdate.setActive(false);
					employeeRepository.save(employeeToUpdate);
					return true;
				}
			}
		} else {
			throw new IllegalArgumentException(CommonMessages.ID_NOT_NULL_EMPTY.message());
		}
		return false;
	}

	@Override
	public boolean importData(File file) throws Throwable {
		try {
			List<Map<String, String>> employeesData = reader.getCsvFileLines(file);
			if (!employeesData.isEmpty()) {
				List<Employee> employees = new ArrayList<Employee>();
				for (Map<String, String> employeeData : employeesData) {
					Employee employee = new Employee();
					
				}
			} else {
				// parsing failed
			}
		} catch (Throwable cause) {
			throw new Throwable(cause);
		}

		return false;
	}

}
