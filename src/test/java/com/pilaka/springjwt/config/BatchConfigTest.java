package com.pilaka.springjwt.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.gen5.api.AfterAll;
import org.junit.gen5.api.AfterEach;
import org.junit.gen5.api.BeforeAll;
import org.junit.gen5.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BatchConfigTest {
	@AfterAll
	void afterAll() {
		System.out.println("Running Before Test");
	}
	
	@BeforeAll
	void beforeAll() {
		System.out.println("Running Before Test");
	}
	
	@BeforeEach
	void setUp() {
		System.out.println("Running Before Test");	}
	@AfterEach
	void tearDown() {
		System.out.println("Running Before Test");
	}



	@Test
	void testMethod1() {
		fail("Not yet implemented");
	}
	
	

}
