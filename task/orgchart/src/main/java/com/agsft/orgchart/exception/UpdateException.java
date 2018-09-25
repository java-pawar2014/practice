package com.agsft.orgchart.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateException extends Exception {

	private static final long serialVersionUID = -1005917721950383795L;

	private String message;

}
