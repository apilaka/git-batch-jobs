package com.pilaka.springjwt.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pilaka.springjwt.entity.Employee;

class EmployeeMapperTest {
	
	 EmployeeMapper mapper;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Not yet setUpBeforeClass");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Not yet tearDownAfterClass");
	}

	@BeforeEach
	void setUp() throws Exception {
		 mapper=new EmployeeMapper();
		System.out.println("Not yet @BeforeEach");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Not yet @AfterEach");
	}

	@Test
	void shouldMapEmployeeDtoToEmployee() {
		EmployeeDTO dto =	  new EmployeeDTO(1111, "Ananta R Pilaka", "apilaka@yahoo.ca", "Male");
		Employee employee = mapper.toEmployee(dto);
		
		Assertions.assertEquals(dto.getEmployeeId(), employee.getEmployeeId());
		Assertions.assertEquals(dto.getEmployeeName(), employee.getEmployeeName());
		Assertions.assertEquals(dto.getEmail(), employee.getEmail());
		Assertions.assertEquals(dto.getGender(), employee.getGender());
		

	}
	
	
	@Test
	void shouldMapEmployeeToEmployeeDto() {
		Employee employee =	  new Employee(1111, "Ananta R Pilaka", "apilaka@yahoo.ca", "Male");
		EmployeeDTO employeeDTO = mapper.toEmployeeDTO(employee);
		
		Assertions.assertEquals(employee.getEmployeeId(), employeeDTO.getEmployeeId());
		Assertions.assertEquals(employee.getEmployeeName(), employeeDTO.getEmployeeName());
		Assertions.assertEquals(employee.getEmail(), employeeDTO.getEmail());
		Assertions.assertEquals(employee.getGender(), employeeDTO.getGender());
	}
	
	@Test
	void shouldThrowExceptionIfEmployeeDtoIsNull(EmployeeDTO dto){
		
		var msg = Assertions.assertThrows(NullPointerException.class,()->mapper.toEmployee(null));
		assertEquals(msg, "employee DTO is null",msg.getMessage());
	
			

		
	}
		


}
