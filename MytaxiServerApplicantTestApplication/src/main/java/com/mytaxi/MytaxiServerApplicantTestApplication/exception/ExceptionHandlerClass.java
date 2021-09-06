package com.mytaxi.MytaxiServerApplicantTestApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mytaxi.MytaxiServerApplicantTestApplication.dto.ErrorResponse;

@RestControllerAdvice
public class ExceptionHandlerClass {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception exception){
		return new ResponseEntity<>(exception.toString(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
				
		StringBuilder errorMessage = new StringBuilder();
	    
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	    	if(errorMessage.length() != 0) {
	    		errorMessage.append(", ");
	    	}
	    	errorMessage.append(error.getDefaultMessage());
	    });
	    
	    BadRequestDataException badDataException = new BadRequestDataException.Builder()
	    		.errorMessage(errorMessage.toString())
	    		.developerMessage(errorMessage.toString()).build();
	    
	    return new ResponseEntity<>(badDataException.getErrorResponse(), 
	    		badDataException.getErrorResponse().getResponseStatus());
	}
}
