package com.agsft.orgchart.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaveException extends Exception {

	private static final long serialVersionUID = 5289305747087096554L;

	private String message;

}
