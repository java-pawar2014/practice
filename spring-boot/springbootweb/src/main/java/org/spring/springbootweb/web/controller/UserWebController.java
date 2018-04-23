package org.spring.springbootweb.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.springbootweb.util.bean.UserRole;
import org.spring.springbootweb.web.bean.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = { "/user" })
public class UserWebController {

	private Log logger = LogFactory.getLog(UserWebController.class);

	@GetMapping(path = "/search/{user-number}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserDTO> search(@PathVariable("user-number") String userNumber) {
		logger.info("Invoked search(String) for user-number = " + userNumber);
		ResponseEntity<UserDTO> response = null;
		UserDTO user = new UserDTO();

		user.setFirstName("Google");
		user.setLastName("Mail");
		user.setContact("55241541");
		user.setEmail("abc@gmail.com");
		user.setRole(UserRole.ADMIN.name());
		response = ResponseEntity.ok(user);
		logger.info("Search response : " + response);
		return response;
	}

}
