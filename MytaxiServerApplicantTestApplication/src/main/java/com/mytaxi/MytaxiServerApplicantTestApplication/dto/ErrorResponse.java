package com.mytaxi.MytaxiServerApplicantTestApplication.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import com.mytaxi.MytaxiServerApplicantTestApplication.entity.ModelBase;
import com.mytaxi.MytaxiServerApplicantTestApplication.exception.BadRequestDataException;
import com.mytaxi.MytaxiServerApplicantTestApplication.exception.BadRequestDataException.Builder;

@Getter
@Setter
public class ErrorResponse extends ModelBase {

    private int responseCode;
    private HttpStatus responseStatus;
    private String errorMsg;
    private String developerMsg;

    public ErrorResponse(final Builder builder) {
    	this.responseCode = builder.responseCode;
        this.responseStatus = builder.responseStatus;
        this.errorMsg = builder.errorMsg;
        this.developerMsg = builder.developerMsg;
    }

    public static class Builder {
    	private int responseCode;
        private HttpStatus responseStatus;
        private String errorMsg;
        private String developerMsg;
        
        public Builder(){}
		
		public Builder errorMessage(String errorMessage) {
			this.errorMsg = errorMessage;
			return this;
		}
		
		public Builder developerMessage(String developerMessage) {
			this.developerMsg = developerMessage;
			return this;
		}
		
		public Builder responseStatus(HttpStatus responseStatus) {
			this.responseStatus = responseStatus;
			return this;
		}
		
		public Builder responseCode(int responseCode) {
			this.responseCode = responseCode;
			return this;
		}
		
		public ErrorResponse build() {
			return new ErrorResponse(this);
		}
    	
    }
}