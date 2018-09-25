package com.agsft.orgchart.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agsft.orgchart.enums.ECommonMessages;
import com.agsft.orgchart.enums.EEmployee;
import com.agsft.orgchart.enums.EResponseStatus;
import com.agsft.orgchart.exception.DataNotFoundException;
import com.agsft.orgchart.exception.UpdateException;
import com.agsft.orgchart.service.IEmployeeService;
import com.agsft.orgchart.util.ErrorList;
import com.agsft.orgchart.web.exception.OrgchartException;
import com.agsft.orgchart.web.model.EmployeeDTO;
import com.agsft.orgchart.web.response.WebResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;

/**
 * @author bpawar
 *
 */
@RestController
@RequestMapping(path = { "/employee" })
@CrossOrigin(origins = "*")
@Api
@NoArgsConstructor
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@GetMapping(path = { "/search/all" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Search all employees")
	public ResponseEntity<WebResponse> searchAll() throws OrgchartException {
		WebResponse response = null;
		try {
			List<EmployeeDTO> foundDepartment = employeeService.searchAll();
			response = new WebResponse(HttpStatus.OK.value(), EResponseStatus.FETCHED.getMessage(), foundDepartment);
		} catch (Throwable cause) {
			throw new OrgchartException(HttpStatus.NO_CONTENT.value(), cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping(path = { "/search/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Search employee by ID")
	public ResponseEntity<WebResponse> searchById(@PathVariable String id)
			throws DataNotFoundException, OrgchartException {
		WebResponse response = null;
		if (id == null || id.isEmpty())
			throw new OrgchartException(EResponseStatus.BINDING_ERROR.getCode(),
					ECommonMessages.PARAM_NOT_NULL_EMPTY.message());
		else {
			try {
				EmployeeDTO foundEmployee = employeeService.searchById(id);
				response = new WebResponse(HttpStatus.OK.value(), EResponseStatus.FETCHED.getMessage(), foundEmployee);
			} catch (Throwable cause) {
				throw new OrgchartException(HttpStatus.NO_CONTENT.value(), cause.getMessage());
			}
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping(path = { "/search/email" }, params = { "email" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Search employee by Email")
	public ResponseEntity<WebResponse> searchByName(@RequestParam(name = "email") String email)
			throws OrgchartException {
		WebResponse response = null;
		if (email == null || email.isEmpty())
			throw new OrgchartException(EResponseStatus.BINDING_ERROR.getCode(),
					ECommonMessages.PARAM_NOT_NULL_EMPTY.message());
		else {
			try {
				EmployeeDTO foundEmployee = employeeService.searchByEmail(email);
				response = new WebResponse(HttpStatus.OK.value(), EResponseStatus.FETCHED.getMessage(), foundEmployee);
			} catch (Throwable cause) {
				throw new OrgchartException(HttpStatus.NO_CONTENT.value(), cause.getMessage());
			}
		}
		return ResponseEntity.ok(response);
	}

	@PostMapping(path = { "/add" }, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Add new employee")
	public ResponseEntity<WebResponse> add(@RequestBody @Validated EmployeeDTO employee, Errors errors)
			throws OrgchartException {
		WebResponse response = null;
		EmployeeDTO savedEmployee = null;
		if (errors.hasErrors()) {
			ErrorList errorList = new ErrorList();
			errorList.addAllObjectErrors(errors.getAllErrors());
			throw new OrgchartException(EResponseStatus.BINDING_ERROR.getCode(), errorList.toString());
		}
		try {
			if (employee != null) {
				savedEmployee = employeeService.save(employee);
				response = new WebResponse(HttpStatus.OK.value(), EEmployee.SAVE_SUCCESS.value(), savedEmployee);
			} else {
				throw new OrgchartException(EEmployee.SAVE_FAIL.value());
			}
		} catch (Throwable cause) {
			throw new OrgchartException(EResponseStatus.FAIL.getCode(), cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}

	@PutMapping(path = { "/update" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Update existing employee or add new if not exist")
	public ResponseEntity<WebResponse> update(@RequestBody @Validated EmployeeDTO employee, Errors errors)
			throws OrgchartException {
		WebResponse response = null;
		EmployeeDTO savedEmployee = null;

		if (errors.hasErrors()) {
			ErrorList errorList = new ErrorList();
			errorList.addAllObjectErrors(errors.getAllErrors());
			throw new OrgchartException(EResponseStatus.BINDING_ERROR.getCode(), errorList.toString());
		}
		try {
			if (employee != null) {
				try {
					savedEmployee = employeeService.update(employee);
					response = new WebResponse(HttpStatus.OK.value(), EEmployee.UPDATE_SUCCESS.value(), savedEmployee);
				} catch (UpdateException cause) {
					throw new OrgchartException(cause.getMessage());
				}
			} else {
				throw new OrgchartException(EEmployee.UPDATE_FAIL.value());
			}
		} catch (Throwable cause) {
			throw new OrgchartException(EResponseStatus.FAIL.getCode(), cause.getMessage(), savedEmployee);
		}
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(path = { "/remove/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Remove employee by id")
	public ResponseEntity<WebResponse> removeById(@PathVariable String id) throws OrgchartException {
		WebResponse response = null;
		if (id == null || id.isEmpty())
			throw new OrgchartException(EResponseStatus.BINDING_ERROR.getCode(),
					ECommonMessages.PARAM_NOT_NULL_EMPTY.message());
		try {
			boolean deleteFlag = employeeService.removeById(id);
			if (deleteFlag)
				response = new WebResponse(HttpStatus.OK.value(), EEmployee.REMOVE_SUCCESS.value(), null);
		} catch (Exception cause) {
			throw new OrgchartException(EResponseStatus.FAIL.getCode(), cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(path = { "/remove/email" }, params = { "email" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Remove employee by email")
	public ResponseEntity<WebResponse> removeByEmail(@RequestParam(name = "email") String email)
			throws OrgchartException {
		WebResponse response = null;
		if (email == null || email.isEmpty())
			throw new OrgchartException(EResponseStatus.BINDING_ERROR.getCode(),
					ECommonMessages.PARAM_NOT_NULL_EMPTY.message());
		try {
			boolean deleteFlag = employeeService.removeByEmail(email);
			if (deleteFlag)
				response = new WebResponse(HttpStatus.OK.value(), EEmployee.REMOVE_SUCCESS.value(), null);
		} catch (Exception cause) {
			throw new OrgchartException(EResponseStatus.FAIL.getCode(), cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}

}
