package org.springboot.webapp.exception;

public class ProductException extends RuntimeException {

	private static final long serialVersionUID = 9024500697497920891L;

	public ProductException() {
		super();
	}

	public ProductException(String message) {
		super(message);
	}

	public ProductException(Throwable cause) {
		super(cause);
	}

	public ProductException(String message, Throwable cause) {
		super(message, cause);
	}
}