package com.hcl.resttemplate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hcl.resttemplate.dto.ErrorResponse;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> employeeException(Exception e) {
		return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomValidationException.class)
	public ResponseEntity<ErrorResponse> validationException(Exception e) {
		return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllException(Exception e) {
		return new ResponseEntity<>(
				new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
