package com.example.Demojunit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;

public class TestCalculator {

	Calculator c = null;
	
	@Mock
	CalculatorService service;
	
	@Rule public MockitoRule rule = MockitoJUnit.rule();
	
//	CalculatorService service = new CalculatorService() {
//		
//		public int add(int i, int j) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//	};
	
	@Before
	public void setUp() {
		c = new Calculator(service);
	}
	
	@Test
	public void testPerform() {
		when(service.add(2, 3)).thenReturn(5);
		assertEquals(10,c.perform(2, 3));
		verify(service).add(2, 3); //whether service.add() was called
	}
	
}
