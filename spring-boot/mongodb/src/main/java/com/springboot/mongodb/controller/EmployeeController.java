package com.springboot.mongodb.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongodb.bean.Employee;
import com.springboot.mongodb.data.repository.EmployeeRepository;
import com.springboot.mongodb.response.UniversalResponse;
import com.springboot.mongodb.service.EmployeeService;
import com.springboot.mongodb.service.handler.EmployeeServiceHandler;
import com.springboot.mongodb.status.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(path = { "/employee" })
@Api(value = "employee")
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	private static final String SAVE_SUCCESS = "Employee saved successfully";
	private static final String FETCHED = "Employee(s) fetched successfully";

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
		LOGGER.info("Initialized EmployeeController with state EmployeeSerice");
	}

	@PostMapping(path = { "/save" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "save")
	public ResponseEntity<UniversalResponse> save(@RequestBody @Valid Employee employee,
			@Autowired @ApiIgnore UniversalResponse response, @ApiIgnore Errors errors) {
		LOGGER.info("Invoked save(Employee, UniversalResponse, Errors)");
		Employee savedEmployee = null;

		try {
			if (errors.hasErrors()) {
				LOGGER.error("Request binding errors found");
				StringBuilder errorBuilder = new StringBuilder();
				for (FieldError error : errors.getFieldErrors())
					errorBuilder.append(error.getDefaultMessage()).append("\n");
				throw new RuntimeException(errorBuilder.toString());
			}
			savedEmployee = employeeService.save(employee);
			response.setStatusMessage(Status.SAVE_SUCCESS.getStatusMessage());
			response.setStatusCode(Status.SAVE_SUCCESS.getValue());
			response.setResponseMessage(SAVE_SUCCESS);
			response.setData(savedEmployee);
			LOGGER.info(SAVE_SUCCESS);
		} catch (RuntimeException cause) {
			response.setStatusMessage(Status.SAVE_FAIL.getStatusMessage());
			response.setStatusCode(Status.SAVE_FAIL.getValue());
			response.setResponseMessage(cause.getMessage());
			response.setData(employee);
			LOGGER.error(cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}

	@PostMapping(path = { "/update/{id}" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "update")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody @Valid Employee employee,
			BindingResult errors) {

		return null;
	}

	@GetMapping(path = { "/deactive/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "deactivate")
	public ResponseEntity<Employee> deactive(@PathVariable String id) {

		return null;
	}

	@GetMapping(path = { "/active/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "activate")
	public ResponseEntity<Employee> active(@PathVariable String id) {

		return null;
	}

	@GetMapping(path = { "/search/all" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "search all")
	public ResponseEntity<UniversalResponse> search(@Autowired @ApiIgnore UniversalResponse response) {
		List<Employee> employees = null;
		try {
			employees = employeeService.search();
			response.setStatusCode(Status.FETCHED.getValue());
			response.setStatusMessage(Status.FETCHED.getStatusMessage());
			response.setResponseMessage(FETCHED);
			response.setData(employees);
		} catch (Exception cause) {
			response.setStatusCode(Status.NO_DATA.getValue());
			response.setStatusMessage(Status.NO_DATA.getStatusMessage());
			response.setResponseMessage(cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping(path = { "/search/{employeeId}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "search by ID")
	public ResponseEntity<UniversalResponse> search(@PathVariable(value = "employeeId") String employeeId,
			@Autowired @ApiIgnore UniversalResponse response) {
		Employee employee = null;
		try {
			employee = employeeService.search(employeeId);
			response.setStatusMessage(Status.FETCHED.getStatusMessage());
			response.setStatusCode(Status.FETCHED.getValue());
			response.setResponseMessage(FETCHED);
			response.setData(employee);
		} catch (RuntimeException cause) {
			response.setStatusMessage(Status.NO_DATA.getStatusMessage());
			response.setStatusCode(Status.NO_DATA.getValue());
			response.setResponseMessage(cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}
}
