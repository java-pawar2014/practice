package com.springboot.mongodb.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongodb.bean.Employee;
import com.springboot.mongodb.exception.MongoApplicationException;
import com.springboot.mongodb.response.UniversalResponse;
import com.springboot.mongodb.service.EmployeeService;
import com.springboot.mongodb.status.Status;
import com.springboot.mongodb.util.ErrorExtractor;
import com.springboot.mongodb.util.ResponseMessage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = { "/employee" })
@Api(value = "employee")
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
		LOGGER.info("Initialized EmployeeController with state EmployeeSerice");
	}

	@PostMapping(path = { "/save" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "save")
	public ResponseEntity<UniversalResponse> save(@RequestBody @Valid final Employee employee, Errors errors)
			throws MongoApplicationException {
		LOGGER.info("Invoked save(Employee, UniversalResponse, Errors)");
		Employee savedEmployee = null;
		UniversalResponse response = null;

		if (errors.hasErrors()) {
			LOGGER.error("Request binding errors found : " + errors.getErrorCount());
			return ResponseEntity.ok(
					new UniversalResponse(
						Status.BINDING_ERROR.value(),
						Status.BINDING_ERROR.message(),
						ErrorExtractor.extractBindingErrors(errors),
						employee));
		}
		try {
			savedEmployee = employeeService.save(employee);
			response = new UniversalResponse(
					Status.SAVE_SUCCESS.value(),
					Status.SAVE_SUCCESS.message(),
					ResponseMessage.SAVE_SUCCESS,
					savedEmployee);
			LOGGER.info(ResponseMessage.SAVE_SUCCESS);
		} catch (RuntimeException cause) {
			response = new UniversalResponse(
					Status.SAVE_FAIL.value(),
					Status.SAVE_FAIL.message(),
					cause.getMessage(),
					employee);
			LOGGER.error(cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}

	@PostMapping(path = { "/update/{id}" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "update")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody @Valid final Employee employee,
			BindingResult errors) throws MongoApplicationException {
		Employee updatedEmployee = null;
		UniversalResponse response = null;

		if (id.isEmpty() || errors.hasErrors()) {
			LOGGER.error("Request binding errors found : " + errors.getErrorCount());
			return ResponseEntity.ok(
					new UniversalResponse(
						Status.BINDING_ERROR.value(),
						Status.BINDING_ERROR.message(),
						ErrorExtractor.extractBindingErrors(errors),
						employee));
		}
		try {
			updatedEmployee = employeeService.update(id, employee);
			response = new UniversalResponse(
					Status.UPDATE_SUCCESS.value(),
					Status.UPDATE_SUCCESS.message(),
					ResponseMessage.UPDATE_SUCCESS,
					updatedEmployee);
			LOGGER.info(ResponseMessage.UPDATE_SUCCESS);
		} catch (RuntimeException cause) {
			response = new UniversalResponse(
					Status.UPDATE_FAIL.value(),
					Status.UPDATE_FAIL.message(),
					cause.getMessage(),
					employee);
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping(path = { "/delete/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "delete")
	public ResponseEntity<UniversalResponse> deactivate(@PathVariable String id) {
		UniversalResponse response = null;

		try {
			Employee employee = employeeService.deactivate(id);
			response = new UniversalResponse(
					Status.DELETE_SUCCESS.value(),
					Status.DELETE_SUCCESS.message(),
					ResponseMessage.DELETE_SUCCESS, employee);
		} catch (RuntimeException cause) {
			response = new UniversalResponse(
					Status.DELETE_FAIL.value(),
					Status.DELETE_FAIL.message(),
					cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}

	// @GetMapping(path = { "/active/{id}" }, produces = {
	// MediaType.APPLICATION_JSON_VALUE })
	// @ApiOperation(value = "activate")
	// public ResponseEntity<UniversalResponse> activate(@PathVariable String
	// id) {
	// UniversalResponse response = null;
	// try {
	// Employee employee = employeeService.deactivate(id);
	// response = new UniversalResponse(Status.DELETE_SUCCESS.value(),
	// Status.DELETE_SUCCESS.message(),
	// DELETE_SUCCESS, employee);
	// } catch (RuntimeException cause) {
	// response = new UniversalResponse(Status.DELETE_FAIL.value(),
	// Status.DELETE_FAIL.message(),
	// cause.getMessage(), null);
	// }
	// return ResponseEntity.ok(response);
	// }

	@GetMapping(path = { "/search/all" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "search all")
	public ResponseEntity<UniversalResponse> search() {
		UniversalResponse response = null;
		try {
			List<Employee> employees = employeeService.search();
			response = new UniversalResponse(
					Status.FETCHED.value(),
					Status.FETCHED.message(),
					ResponseMessage.FETCHED,
					employees);
		} catch (Exception cause) {
			response = new UniversalResponse(
					Status.NO_DATA.value(),
					Status.NO_DATA.message(),
					cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping(path = { "/search/{employeeId}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "search by ID")
	public ResponseEntity<UniversalResponse> search(@PathVariable(value = "employeeId") String employeeId) {
		UniversalResponse response = null;
		try {
			Employee employee = employeeService.search(employeeId);
			response = new UniversalResponse(
					Status.FETCHED.value(),
					Status.FETCHED.message(),
					ResponseMessage.FETCHED,
					employee);
		} catch (RuntimeException cause) {
			response = new UniversalResponse(
					Status.NO_DATA.value(),
					Status.NO_DATA.message(),
					cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}
}
