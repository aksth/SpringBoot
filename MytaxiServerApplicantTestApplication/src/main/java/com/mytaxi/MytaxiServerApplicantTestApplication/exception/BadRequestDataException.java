package com.mytaxi.MytaxiServerApplicantTestApplication.exception;

import org.springframework.http.HttpStatus;

import com.mytaxi.MytaxiServerApplicantTestApplication.dto.ErrorResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestDataException extends RuntimeException {

    private ErrorResponse errorResponse;
    
    public BadRequestDataException(final Builder builder) {
        super(builder.errorMessage);
        
        errorResponse = new ErrorResponse.Builder()
        		.developerMessage(builder.developerMessage)
        		.errorMessage(builder.errorMessage)
        		.responseCode(HttpStatus.BAD_REQUEST.value())
        		.responseStatus(HttpStatus.BAD_REQUEST).build();
    }
    
    public static class Builder {
    	
		private String errorMessage;
		private String developerMessage;
		
		public Builder(){}
		
		public Builder errorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
			return this;
		}
		
		public Builder developerMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}
		
		public BadRequestDataException build() {
			return new BadRequestDataException(this);
		}
		
	}
}
