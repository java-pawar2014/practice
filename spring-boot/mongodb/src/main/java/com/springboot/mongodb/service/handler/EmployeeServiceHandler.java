package com.springboot.mongodb.service.handler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mongodb.bean.Employee;
import com.springboot.mongodb.data.repository.EmployeeRepository;
import com.springboot.mongodb.service.EmployeeService;
import com.springboot.mongodb.util.ResponseMessage;

@Service
public class EmployeeServiceHandler implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceHandler.class);


	private EmployeeRepository repository;

	@Autowired
	public EmployeeServiceHandler(EmployeeRepository repository) {
		this.repository = repository;
		LOGGER.info("Initialized EmployeeServiceHandler with state EmployeeRepository");
	}

	@Override
	public Employee save(Employee employee) {
		LOGGER.info("Invoked save(Employee)");
		Employee savedEmployee = null;

		try {
			savedEmployee = repository.save(employee);
			if (savedEmployee == null) {
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			throw new RuntimeException(ResponseMessage.SAVE_FAILED);
		}
		return savedEmployee;
	}

	@Override
	public Employee update(String employeeId, Employee employee) {
		LOGGER.info("Invoked update(String, Employee) for ID " + employeeId);
		Employee updatedEmployee = null;
		Employee foundEmployee = null;

		try {
			foundEmployee = repository.findById(employeeId).get();
			if (foundEmployee == null) {
				throw new RuntimeException();
			}
		} catch (RuntimeException cause) {
			throw new RuntimeException(ResponseMessage.NOT_FOUND + employeeId);
		}
		foundEmployee.setActive(employee.isActive());
		foundEmployee.setAge(employee.getAge());
		foundEmployee.setFirstName(employee.getFirstName());
		foundEmployee.setLastName(employee.getLastName());
		try {
			updatedEmployee = repository.save(foundEmployee);
			if (updatedEmployee == null) {
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			throw new RuntimeException(ResponseMessage.UPDATE_FAILED + employeeId);
		}
		return updatedEmployee;
	}

	@Override
	public Employee deactivate(String employeeId) {
		LOGGER.info("Invoked deactivate(String) for ID " + employeeId);
		Employee updatedEmployee = null;
		Employee foundEmployee = null;

		try {
			foundEmployee = repository.findById(employeeId).get();
			if (foundEmployee == null) {
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			throw new RuntimeException(ResponseMessage.NOT_FOUND + employeeId);
		}
		foundEmployee.setActive(false);
		try {
			updatedEmployee = repository.save(foundEmployee);
			if (updatedEmployee == null) {
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			throw new RuntimeException(ResponseMessage.UPDATE_FAILED + employeeId);
		}
		return updatedEmployee;
	}

	@Override
	public Employee active(String employeeId) {
		LOGGER.info("Invoked active(String) for ID " + employeeId);
		Employee updatedEmployee = null;
		Employee foundEmployee = null;

		try {
			foundEmployee = repository.findById(employeeId).get();
			if (foundEmployee == null) {
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			throw new RuntimeException(ResponseMessage.NOT_FOUND + employeeId);
		}
		foundEmployee.setActive(true);
		try {
			updatedEmployee = repository.save(foundEmployee);
			if (updatedEmployee == null) {
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			throw new RuntimeException(ResponseMessage.UPDATE_FAILED + employeeId);
		}
		return updatedEmployee;
	}

	@Override
	public List<Employee> search() {
		List<Employee> foundEmployees = null;

		try {
			foundEmployees = repository.findAll();
			if (foundEmployees == null || foundEmployees.isEmpty()) {
				throw new RuntimeException();
			}
		} catch (RuntimeException cause) {
			throw new RuntimeException(ResponseMessage.NO_EMPLOYEES);
		}

		return foundEmployees;
	}

	@Override
	public Employee search(String employeeId) {
		Employee foundEmployee = null;

		try {
			foundEmployee = repository.findById(employeeId).get();
			if (foundEmployee == null) {
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			throw new RuntimeException(ResponseMessage.NOT_FOUND + employeeId);
		}
		return foundEmployee;
	}
}
