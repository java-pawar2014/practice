package com.springmvc.simpleform.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springmvc.simpleform.bean.EmployeeBean;

public class EmployeeBeanValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(EmployeeBean.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EmployeeBean employee = (EmployeeBean) target;

		if (employee.getFirstName() == null || employee.getFirstName() == "") {
			errors.rejectValue("firstName", "empty.fname");
		}
		if (employee.getLastName() == null || employee.getLastName() == "") {
			errors.rejectValue("lastName", "empty.lname");
		}
		if (employee.getCity() == null || employee.getCity() == "") {
			errors.rejectValue("city", "empty.city");
		}
		if (employee.getBirthDate() == null) {
			errors.rejectValue("birthDate", "empty.birthdate");
		}
		if (employee.getContact() == null || employee.getContact() == "") {
			errors.rejectValue("contact", "empty.contact");
		}
		if (employee.getEmail() == null || employee.getEmail() == "") {
			errors.rejectValue("email", "empty.email");
		}
		if (employee.getEmail() != null && employee.getEmail() != "") {
			if (!employee.getEmail().contains("@")) {
				errors.rejectValue("email", "email.invalid");
			}
		}
	}
}
