package org.springboot.json.web.controller;

import org.springboot.json.web.bean.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = { "/user" })
@Api(value = "User controller")
public class UserController {

	@ApiOperation(value = "Search user for ID")
	@GetMapping(path = { "/search/{userId}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDTO> getUser(@PathVariable(name = "userId", required = true) String userId) {

		UserDTO user = new UserDTO();

		user.setUserId(userId);
		user.setFirstName("FNAME" + userId);
		user.setLastName("LNAME" + userId);
		user.setContact("CONTACT" + userId);
		user.setEmail("EMAIL" + userId);
		return ResponseEntity.ok(user);
	}
}
