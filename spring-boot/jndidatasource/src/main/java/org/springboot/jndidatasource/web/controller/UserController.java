package org.springboot.jndidatasource.web.controller;

import java.util.Optional;

import org.springboot.jndidatasource.data.entity.UserEntity;
import org.springboot.jndidatasource.data.repository.UserRepository;
import org.springboot.jndidatasource.response.Response;
import org.springboot.jndidatasource.web.request.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/user")
@Api(value = "User Operations")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	private ObjectMapper objectMapper;

	public UserController() {
		objectMapper = new ObjectMapper();
	}

	@GetMapping(path = { "/search/{userId}" }, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value = "Search the user by ID")
	public ResponseEntity<Response> search(@PathVariable(name = "userId") long userId) {

		Response response = new Response();
		try {
			Optional<UserEntity> userData = userRepository.findById(userId);
			UserEntity userEntity = userData.get();
			if (userEntity != null) {
				UserBean user = objectMapper.convertValue(userEntity, UserBean.class);
				response.setStatus(HttpStatus.OK.value());
				response.setMessage("User fetched successfully");
				response.setBody(user);
				return new ResponseEntity<Response>(response, HttpStatus.OK);
			} else {
				throw new RuntimeException();
			}
		} catch (RuntimeException cause) {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			response.setMessage("User not found for ID " + userId);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
	}

	@PostMapping(path = { "/add" }, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value = "Add new user")
	public ResponseEntity<Response> add(@RequestBody UserBean user) {

		UserEntity userEntity = objectMapper.convertValue(user, UserEntity.class);
		UserEntity savedUser = userRepository.save(userEntity);
		Response response = new Response();
		if (savedUser != null) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("User saved successfully");
			response.setBody(objectMapper.convertValue(savedUser, UserBean.class));
		} else {
			response.setStatus(HttpStatus.EXPECTATION_FAILED.value());
			response.setMessage("Failed to save the user details");
			response.setBody(user);
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
