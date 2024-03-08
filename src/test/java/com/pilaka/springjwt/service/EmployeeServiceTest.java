/**
 * 
 */
package com.pilaka.springjwt.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.pilaka.springjwt.dto.EmployeeDTO;
import com.pilaka.springjwt.dto.EmployeeMapper;
import com.pilaka.springjwt.entity.Employee;
import com.pilaka.springjwt.repository.EmployeeRepository;

/**
 * 
 */
class EmployeeServiceTest {

@InjectMocks
private EmployeeRepository employeeRepository;

@InjectMocks
private EmployeeMapper mapper;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(employeeRepository);
		
		long employee_id = 9999;
		String employee_name = "Ananta";
		String email = "apilaka@yahoo.ca";
		String gender = "Male";

		Employee employee= new Employee(employee_id, employee_name, email, gender);

		
		long employee_id1 = 9999;
		String employee_name1 = "Ananta";
		String email1 = "apilaka@yahoo.ca";
		String gender1 = "Male";
		EmployeeDTO dto= new EmployeeDTO(employee_id1, employee_name1, email1, gender1);
		
		Mockito.when(mapper.toEmployee(dto)).thenReturn(employee);
	}
	@Test
	public void shouldSuccessfullyListEmployees()
	{
		
	}
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testEmployeeService() {
		fail("Not yet implemented");
	}
	@Test
	void testListEmployees() {
		fail("Not yet implemented");
	}
	@Test
	void testAddEmployee() {
		fail("Not yet implemented");
	}

}
