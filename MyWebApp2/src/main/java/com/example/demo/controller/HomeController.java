package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;

@RestController
public class HomeController {

	@GetMapping(value = "person")
	public ResponseEntity<List<Person>> getPerson (){
		System.out.println("getPerson invoked");
		
		List<Person> list = new ArrayList<Person>();
		list.add(new Person.Builder().name("name1").build());
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "person/{id}")
	public ResponseEntity<Person> getPersonById (@PathVariable ("id") int id){
		System.out.println("getPersonById invoked, id = "+id);
		try {
		return new ResponseEntity<>(new Person.Builder().name("name with id "+id).build(), HttpStatus.OK);
		}catch(Exception e) {
			throw e;
		}
	}
	
}
