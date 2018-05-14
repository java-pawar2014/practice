package com.springboot.mongodb.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.springboot.mongodb.bean.Customer;
import com.springboot.mongodb.data.repository.CustomerRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = { "/customer" })
@Api
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping(path = { "/save" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "save")
	public ResponseEntity<Customer> save(@RequestBody Customer customer) {

		return ResponseEntity.ok(customerRepository.save(customer));
	}

	@PostMapping(path = { "/update/{id}" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "update")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody @Valid Customer customer,
			BindingResult errors) {

		if (errors.hasErrors()) {
			return ResponseEntity.unprocessableEntity().body(errors.getAllErrors());
		} else {
			Customer updateCustomer = customerRepository.findById(id).get();
			updateCustomer.setFirstName(customer.getFirstName());
			updateCustomer.setLastName(customer.getLastName());
			updateCustomer.setActive(customer.isActive());
			return ResponseEntity.ok(customerRepository.save(updateCustomer));
		}
	}

	@GetMapping(path = { "/deactive/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "deactivate")
	public ResponseEntity<Customer> deactive(@PathVariable String id) {

		Customer updateCustomer = customerRepository.findById(id).get();
		updateCustomer.setActive(false);

		return ResponseEntity.ok(customerRepository.save(updateCustomer));
	}

	@GetMapping(path = { "/active/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "activate")
	public ResponseEntity<Customer> active(@PathVariable String id) {

		Customer updateCustomer = customerRepository.findById(id).get();
		updateCustomer.setActive(true);

		return ResponseEntity.ok(customerRepository.save(updateCustomer));
	}

	@GetMapping(path = { "/search/all" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "search all")
	public ResponseEntity<List<Customer>> search() {

		return ResponseEntity.ok(customerRepository.findAll());
	}

}
