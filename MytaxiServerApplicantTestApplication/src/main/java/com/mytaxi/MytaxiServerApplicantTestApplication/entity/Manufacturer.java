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
public class Manufacturer extends ModelBase{

	@Id
	@Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Basic(optional = false)
	@NotBlank(message = "Manufacturer name is mandatory")
	private String manufacturerName;
	
	@Column
	@Basic(optional = false)
	private char status;
	
	@Column
    @Basic(optional = false)
	private ZonedDateTime createdDate;
	
}
