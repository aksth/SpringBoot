package com.mytaxi.MytaxiServerApplicantTestApplication.entity;

import java.time.ZonedDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Driver extends ModelBase{

	@Id
	@Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Basic(optional = false)
	@NotBlank(message = "License number is mandatory")
	private String licenseNumber;
	
	@Column
	@Basic(optional = false)
	private char status;
	
	@Column
    @Basic(optional = false)
	private ZonedDateTime createdDate;
	
	public Driver() {}
	
	Driver(final Builder builder){
		this.licenseNumber = builder.licenseNumber;
		this.status = builder.status;
		this.createdDate = builder.createdDate;
	}
	
	public static class Builder {
		private String licenseNumber;
		private char status;
		private ZonedDateTime createdDate;
		
		public Builder () {}
		
		public Builder licenseNumber(String licenseNumber) {
			this.licenseNumber = licenseNumber;
			return this;
		}
		public Builder status(Character status) {
			this.status = status;
			return this;
		}
		public Builder createdDate(ZonedDateTime createdDate) {
			this.createdDate = createdDate;
			return this;
		}
		public Driver build() {
			return new Driver(this);
		}
	}
	
}
