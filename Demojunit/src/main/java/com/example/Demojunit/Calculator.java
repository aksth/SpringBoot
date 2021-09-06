package com.example.Demojunit;

public class Calculator {
	
	CalculatorService service;
	
	public Calculator (CalculatorService service) {
		this.service = service;
	}
	
	public int perform(int i, int j) {	//2 3 -> (i+j)*2
		return service.add(i, j)*i;
		//return (i+j)*i;
		// verify(service).add(2, 3) will fail if value directly returned.
	}
	
}
