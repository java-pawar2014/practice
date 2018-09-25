package com.agsft.mongotx.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agsft.mongotx.application.common.Message;
import com.agsft.mongotx.service.creator.IPersonService;
import com.agsft.mongotx.web.exception.TransactionException;
import com.agsft.mongotx.web.model.request.PersonDTO;
import com.agsft.mongotx.web.model.response.WebResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping(path = { "/person" })
@Api
@NoArgsConstructor
public class PersonController {

	@Autowired
	private IPersonService service;

	@GetMapping(path = { "/search/all" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Search all persons")
	public ResponseEntity<WebResponse> searchAll() throws TransactionException {
		return ResponseEntity.ok(new WebResponse(HttpStatus.OK.value(), Message.FETCHED.value(), service.searchAll()));
	}

	@GetMapping(path = { "/search/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE }, params = { "id" })
	@ApiOperation(value = "Search person by ID")
	public ResponseEntity<WebResponse> searchById(@PathVariable String id) throws TransactionException {
		if (id == null || id.trim().isEmpty())
			throw new TransactionException(HttpStatus.OK.value(), "Person ID cannot be null or empty");
		return ResponseEntity
				.ok(new WebResponse(HttpStatus.OK.value(), Message.FETCHED.value(), service.searchById(id)));
	}

	@GetMapping(path = { "/search/{email}" }, produces = { MediaType.APPLICATION_JSON_VALUE }, params = { "email" })
	@ApiOperation(value = "Search person by Email")
	public ResponseEntity<WebResponse> searchByEmail(@PathVariable String email) throws TransactionException {
		if (email == null || email.trim().isEmpty())
			throw new TransactionException(HttpStatus.OK.value(), "Person email cannot be null or empty");
		return ResponseEntity
				.ok(new WebResponse(HttpStatus.OK.value(), Message.FETCHED.value(), service.searchByEmail(email)));
	}

	@PostMapping(path = { "/save/multiple" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Save all persons")
	public ResponseEntity<WebResponse> saveAll(@RequestBody @Validated List<PersonDTO> persons)
			throws TransactionException {
		if (persons == null || persons.isEmpty())
			throw new TransactionException(HttpStatus.OK.value(),
					"Person list cannot be null or empty, please provide atleast one entity to save");
		return ResponseEntity
				.ok(new WebResponse(HttpStatus.OK.value(), "Person(s) saved successfully", service.saveAll(persons)));
	}

	@PostMapping(path = { "/save" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Save individual person")
	public ResponseEntity<WebResponse> save(@RequestBody @Validated PersonDTO person) throws TransactionException {
		if (person == null)
			throw new TransactionException(HttpStatus.OK.value(),
					"Person cannot be null, please provide atleast one entity to save");
		return ResponseEntity
				.ok(new WebResponse(HttpStatus.OK.value(), "Person saved successfully", service.save(person)));
	}
}
