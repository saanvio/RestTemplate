package com.hcl.resttemplate.exception;

public class CustomValidationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CustomValidationException(String message) {
		super(message);
	}

}