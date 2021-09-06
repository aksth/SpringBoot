package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerClass {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception exception){
		return new ResponseEntity<>(exception.toString(), HttpStatus.BAD_REQUEST);
	}
}
