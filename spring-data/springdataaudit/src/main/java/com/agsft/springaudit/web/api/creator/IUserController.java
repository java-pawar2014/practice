package com.agsft.springaudit.web.api.creator;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agsft.springaudit.exception.AuditingException;
import com.agsft.springaudit.web.model.UserDTO;
import com.agsft.springaudit.web.response.WebResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = { "/user" })
@Api
public interface IUserController {

	@GetMapping(path = { "/search/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Return User with details for provided ID")
	ResponseEntity<WebResponse> searchById(@PathVariable int id) throws AuditingException;

	@PostMapping(path = { "/add" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Save new User")
	ResponseEntity<WebResponse> save(@RequestBody UserDTO user, Errors errors) throws AuditingException;

	@PutMapping(path = { "/update" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Update existing User if found of provided ID else create new User")
	ResponseEntity<WebResponse> update(@RequestBody UserDTO user, Errors errors) throws AuditingException;
}
