package com.agsft.mongotx.web.model.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bpawar
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO implements Serializable {

	private static final long serialVersionUID = -5696986059554824460L;

	private String _id;
	@NotEmpty(message = "First Name cannot be empty")
	private String firstName;

	@NotEmpty(message = "Last Name cannot be empty")
	private String lastName;

	@NotEmpty(message = "Contact cannot be empty")
	private String contact;

	@NotEmpty(message = "Email cannot be empty")
	@Email(message = "Please provide valid email ID")
	private String email;

	private String city;

	@JsonFormat(pattern = "MM-dd-yyyy")
	private Date birthDate;

}
