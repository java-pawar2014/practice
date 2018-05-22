package com.agsft.orgchart.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agsft.orgchart.enums.ResponseStatus;
import com.agsft.orgchart.service.IEmployeeService;
import com.agsft.orgchart.web.model.EmployeeDTO;
import com.agsft.orgchart.web.response.WebResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = { "/employee" })
@CrossOrigin(origins = "*")
@Api
public class EmployeeController {

	private IEmployeeService employeeService;

	@Autowired
	public EmployeeController(IEmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping(path = { "/search/all" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "search all")
	public ResponseEntity<WebResponse> findAll() {
		WebResponse response = new WebResponse();
		List<EmployeeDTO> employees = employeeService.findAll();
		if (employees.isEmpty()) {
			response.setStatusCode(ResponseStatus.NO_CONTENT.getCode());
			response.setMessage(ResponseStatus.NO_CONTENT.getMessage());
		} else {
			response.setStatusCode(ResponseStatus.FETCHED.getCode());
			response.setMessage(ResponseStatus.FETCHED.getMessage());
			response.setData(employees);
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping(path = { "/search" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "search")
	public ResponseEntity<EmployeeDTO> search() {
		return null;
	}
}
