package com.capgemini.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalException {


	
		
		@ExceptionHandler(value =  Exception.class)
		public ResponseEntity<String> handleException(Exception c) {
			return new ResponseEntity<String>(c.getMessage(), HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler(value =  CustomerException.class)
		public ResponseEntity<String> handleEmployeeException(CustomerException c) {
			return new ResponseEntity<String>(c.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

