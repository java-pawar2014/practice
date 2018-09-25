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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agsft.orgchart.enums.ECommonMessages;
import com.agsft.orgchart.enums.EResponseStatus;
import com.agsft.orgchart.enums.ERole;
import com.agsft.orgchart.service.IRoleService;
import com.agsft.orgchart.util.ErrorList;
import com.agsft.orgchart.web.exception.OrgchartException;
import com.agsft.orgchart.web.model.RoleDTO;
import com.agsft.orgchart.web.response.WebResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping(path = { "/role" })
@CrossOrigin(origins = { "*" })
@Api
@NoArgsConstructor
public class RoleController {

	private IRoleService roleService;


	@PostMapping(path = { "/add" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Add new role")
	public ResponseEntity<WebResponse> add(@RequestBody @Validated RoleDTO role, Errors errors)
			throws OrgchartException {
		WebResponse response = null;
		RoleDTO savedRole = null;
		if (errors.hasErrors()) {
			ErrorList errorList = new ErrorList();
			errorList.addAllObjectErrors(errors.getAllErrors());
			throw new OrgchartException(EResponseStatus.BINDING_ERROR.getCode(), errorList.toString());
		}
		try {
			if (role != null) {
				savedRole = roleService.save(role);
				response = new WebResponse(HttpStatus.OK.value(), ERole.SAVE_SUCCESS.value(), savedRole);
			} else {
				throw new OrgchartException(ERole.SAVE_FAIL.value());
			}
		} catch (Throwable cause) {
			throw new OrgchartException(EResponseStatus.FAIL.getCode(), cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping(path = { "/search/name" }, params = { "name" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Search role by Name")
	public ResponseEntity<WebResponse> searchByName(@RequestParam(name = "name") String name) throws OrgchartException {
		WebResponse response = null;
		if (name == null || name.isEmpty())
			throw new OrgchartException(EResponseStatus.BINDING_ERROR.getCode(),
					ECommonMessages.PARAM_NOT_NULL_EMPTY.message());
		else {
			try {
				RoleDTO foundRole = roleService.searchByName(name);
				response = new WebResponse(HttpStatus.OK.value(), EResponseStatus.FETCHED.getMessage(), foundRole);
			} catch (Throwable cause) {
				throw new OrgchartException(HttpStatus.NO_CONTENT.value(), cause.getMessage());
			}
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping(path = { "/search/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Search role by ID")
	public ResponseEntity<WebResponse> searchById(@PathVariable String id) throws OrgchartException {
		WebResponse response = null;
		if (id == null || id.isEmpty())
			throw new OrgchartException(EResponseStatus.BINDING_ERROR.getCode(),
					ECommonMessages.PARAM_NOT_NULL_EMPTY.message());
		else {
			try {
				RoleDTO foundRole = roleService.searchById(id);
				response = new WebResponse(HttpStatus.OK.value(), EResponseStatus.FETCHED.getMessage(), foundRole);
			} catch (Throwable cause) {
				throw new OrgchartException(HttpStatus.NO_CONTENT.value(), cause.getMessage());
			}
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping(path = { "/search/all" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Search all roles")
	public ResponseEntity<WebResponse> searchAll() throws OrgchartException {
		WebResponse response = null;
		try {
			List<RoleDTO> foundRoles = roleService.searchAll();
			response = new WebResponse(HttpStatus.OK.value(), EResponseStatus.FETCHED.getMessage(), foundRoles);
		} catch (Throwable cause) {
			throw new OrgchartException(HttpStatus.NO_CONTENT.value(), cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(path = { "/remove/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Remove role by id")
	public ResponseEntity<WebResponse> removeById(@PathVariable String id) throws OrgchartException {
		WebResponse response = null;
		if (id == null || id.isEmpty())
			throw new OrgchartException(EResponseStatus.BINDING_ERROR.getCode(),
					ECommonMessages.PARAM_NOT_NULL_EMPTY.message());
		try {
			boolean deleteFlag = roleService.removeById(id);
			if (deleteFlag)
				response = new WebResponse(HttpStatus.OK.value(), ERole.REMOVE_SUCCESS.value(), null);
		} catch (Exception cause) {
			throw new OrgchartException(EResponseStatus.FAIL.getCode(), cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(path = { "/remove/name" }, params = { "name" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Remove role by name")
	public ResponseEntity<WebResponse> removeByName(@RequestParam(name = "name") String name) throws OrgchartException {
		WebResponse response = null;
		if (name == null || name.isEmpty())
			throw new OrgchartException(EResponseStatus.BINDING_ERROR.getCode(),
					ECommonMessages.PARAM_NOT_NULL_EMPTY.message());
		try {
			boolean deleteFlag = roleService.removeByName(name);
			if (deleteFlag)
				response = new WebResponse(HttpStatus.OK.value(), ERole.REMOVE_SUCCESS.value(), null);
		} catch (Exception cause) {
			throw new OrgchartException(EResponseStatus.FAIL.getCode(), cause.getMessage());
		}
		return ResponseEntity.ok(response);
	}
}
