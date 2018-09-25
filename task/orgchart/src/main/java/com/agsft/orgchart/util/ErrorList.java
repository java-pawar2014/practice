package com.agsft.orgchart.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.validation.ObjectError;

public class ErrorList {

	private List<String> errors = new ArrayList<String>();

	public ErrorList() {
	}

	public ErrorList(List<String> errors) {
		this.errors = errors;
	}

	public boolean add(String error) {
		return this.errors.add(error);
	}

	public boolean addAll(Collection<String> errors) {
		return this.errors.addAll(errors);
	}

	public boolean remove(String error) {
		return this.errors.remove(error);
	}

	public String remove(int index) {
		return this.errors.remove(index);
	}

	public List<String> addAllObjectErrors(Collection<ObjectError> objectErrors) {
		List<String> errors = new ArrayList<String>();
		for (ObjectError objectError : objectErrors)
			errors.add(objectError.getDefaultMessage());
		addAll(errors);
		return this.errors;
	}

	public List<String> getAllErrors() {
		return this.errors;
	}

	@Override
	public String toString() {
		StringBuilder errorBuilder = new StringBuilder();
		for (int errorCount = 0; errorCount < this.errors.size(); errorCount++) {
			String error = this.errors.get(errorCount);
			errorBuilder.append(error);
			if (errorCount == this.errors.size() - 1) {
				errorBuilder.append(".");
			} else {
				errorBuilder.append(". ");
			}
		}
		return errorBuilder.toString();
	}

}
