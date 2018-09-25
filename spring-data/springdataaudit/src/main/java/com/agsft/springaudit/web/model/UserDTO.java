package com.agsft.springaudit.web.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

	private int userId;

	private String firstName;

	private String lastName;

	private String email;

	private String contact;

	private String username;

	private String password;
	
	private List<String> strings;
	
	private boolean active;
	
}
