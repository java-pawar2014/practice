package com.springboot.validation.web.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.validation.web.bean.Employee;
import com.springboot.validation.web.exception.CustomException;
import com.springboot.validation.web.response.CustomResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = { "/employee" })
@Api
public class EmployeeController {

	@PostMapping(path = { "/save" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "save")
	public ResponseEntity<?> save(@RequestBody @Validated Employee employee, BindingResult errors)
			throws CustomException {
		if (errors.hasErrors()) {
			throw new CustomException(256, errors.getAllErrors().get(0).getDefaultMessage());
		}

		return ResponseEntity.ok(new CustomResponse(200, "Employee saved successfully", employee));
	}

}
