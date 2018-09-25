package com.agsft.springaudit.web.api.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.agsft.springaudit.exception.AuditingException;
import com.agsft.springaudit.service.creator.IUserService;
import com.agsft.springaudit.web.api.creator.IUserController;
import com.agsft.springaudit.web.model.UserDTO;
import com.agsft.springaudit.web.response.WebResponse;

@Component
public class UserController implements IUserController {

	@Autowired
	private IUserService service;

	@Override
	public ResponseEntity<WebResponse> searchById(@PathVariable int id) throws AuditingException {
		try {
			return ResponseEntity
					.ok(new WebResponse(HttpStatus.OK.value(), "User fetched successfully", service.searchById(id)));
		} catch (Exception cause) {
			throw new AuditingException(HttpStatus.EXPECTATION_FAILED.value(), cause.getMessage());
		}
	}

	@Override
	public ResponseEntity<WebResponse> save(@RequestBody UserDTO user, Errors errors) throws AuditingException {
		if (errors.hasErrors())
			throw new AuditingException(HttpStatus.INTERNAL_SERVER_ERROR.value(),
					errors.getAllErrors().get(0).getDefaultMessage());
		try {
			return ResponseEntity
					.ok(new WebResponse(HttpStatus.OK.value(), "User created successfully", service.save(user)));
		} catch (Exception cause) {
			throw new AuditingException(HttpStatus.EXPECTATION_FAILED.value(), cause.getMessage());
		}
	}

	@Override
	public ResponseEntity<WebResponse> update(@RequestBody UserDTO user, Errors errors) throws AuditingException {
		if (errors.hasErrors())
			throw new AuditingException(HttpStatus.INTERNAL_SERVER_ERROR.value(),
					errors.getAllErrors().get(0).getDefaultMessage());
		try {
			return ResponseEntity
					.ok(new WebResponse(HttpStatus.OK.value(), "User updated successfully", service.update(user)));
		} catch (Exception cause) {
			throw new AuditingException(HttpStatus.EXPECTATION_FAILED.value(), cause.getMessage());
		}
	}

}
