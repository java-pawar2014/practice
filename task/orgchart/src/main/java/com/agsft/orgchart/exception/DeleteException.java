package com.agsft.orgchart.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteException extends Exception {

	private static final long serialVersionUID = 4776971170416871622L;

	private String message;
}
