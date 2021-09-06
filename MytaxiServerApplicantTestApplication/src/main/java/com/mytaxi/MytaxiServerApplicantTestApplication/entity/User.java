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
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

	@Id
	@Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Basic(optional = false)
	@NotBlank(message = "User name is mandatory")
	private String name;
	
	@Column(unique = true)
	@Basic(optional = false)
	@NotBlank(message = "Email is mandatory")
	private String email;
	
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 200)
    private String password;
	
	@Column
	@Basic(optional = false)
	private boolean isDriver;
	
	@JoinColumn
    @ManyToOne
    private Driver driver;
	
	@Column
	@Basic(optional = false)
	private char status;
	
	@Column
    @Basic(optional = false)
	private ZonedDateTime createdDate;
	
	public User() {}
	
	User(final Builder builder){
		this.name = builder.name;
		this.email = builder.email;
	    this.password = builder.password;
		this.isDriver = builder.isDriver;
	    this.driver = builder.driver;
		this.status = builder.status;
		this.createdDate = builder.createdDate;
	}
	
	public static class Builder {
		private String name;
		private String email;
	    private String password;
		private boolean isDriver;
	    private Driver driver;
		private char status;
		private ZonedDateTime createdDate;
		
		public Builder () {}
		
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
		public Builder driver(Driver driver) {
			this.driver = driver;
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
		public User build() {
			return new User(this);
		}
		
		
	}
	
}
