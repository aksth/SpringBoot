package com.mytaxi.MytaxiServerApplicantTestApplication.entity;

import java.time.ZonedDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DriverAssignment extends ModelBase{

	@Id
	@Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn
    @ManyToOne
    private Driver driver;
	
	@JoinColumn
    @ManyToOne
    private Car car;
	
	@Column
    @Basic(optional = false)
	private ZonedDateTime createdDate;
}
