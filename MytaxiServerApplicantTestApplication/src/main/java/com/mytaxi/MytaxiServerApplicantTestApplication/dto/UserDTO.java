package com.mytaxi.MytaxiServerApplicantTestApplication.dto;

import java.time.ZonedDateTime;

import com.mytaxi.MytaxiServerApplicantTestApplication.entity.Driver;
import com.mytaxi.MytaxiServerApplicantTestApplication.entity.ModelBase;
import com.mytaxi.MytaxiServerApplicantTestApplication.entity.User;
import com.mytaxi.MytaxiServerApplicantTestApplication.entity.User.Builder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends ModelBase{
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private Boolean isDriver;
	private String licenseNumber;
	private char status;
	private ZonedDateTime createdDate;
	
	public UserDTO(Long id,
			String name,
			String email,
			String password,
			Boolean isDriver,
			String licenseNumber,
			char status,
			ZonedDateTime createdDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.isDriver = isDriver;
		this.licenseNumber = licenseNumber;
		this.status = status;
		this.createdDate = createdDate;
	}
	
	UserDTO(final Builder builder){
		this.id = builder.id;
		this.name = builder.name;
		this.email = builder.email;
	    this.password = builder.password;
		this.isDriver = builder.isDriver;
		this.licenseNumber = builder.licenseNumber;
		this.status = builder.status;
		this.createdDate = builder.createdDate;
	}
	
	public static class Builder {
		private Long id;
		private String name;
		private String email;
		private String password;
		private Boolean isDriver;
		private String licenseNumber;
		private char status;
		private ZonedDateTime createdDate;
		
		public Builder () {}
		
		public Builder id(Long id) {
			this.id = id;
			return this;
		}
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		public Builder password(String password) {
			this.password = password;
			return this;
		}
		public Builder isDriver(boolean isDriver) {
			this.isDriver = isDriver;
			return this;
		}
		public Builder licenseNumber(String licenseNumber) {
			this.licenseNumber = licenseNumber;
			return this;
		}
		public Builder status(char status) {
			this.status = status;
			return this;
		}
		public Builder createdDate(ZonedDateTime createdDate) {
			this.createdDate = createdDate;
			return this;
		}
		public UserDTO build() {
			return new UserDTO(this);
		}
	}

}
