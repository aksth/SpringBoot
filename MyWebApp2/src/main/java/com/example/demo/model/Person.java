package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Person {
	
	@Id
	private int id;
	
	private String name;
	
	Person(final Builder builder){
		this.name = builder.name;
	}
	
	public static class Builder {
	
		private String name;
		
		public Builder(){}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Person build() {
			return new Person(this);
		}
		
	}
	
}
