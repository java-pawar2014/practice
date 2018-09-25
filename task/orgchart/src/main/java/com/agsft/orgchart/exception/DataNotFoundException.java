package com.agsft.orgchart.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DataNotFoundException extends Exception {

	private static final long serialVersionUID = 6769984843444837540L;

	private String message;

}
