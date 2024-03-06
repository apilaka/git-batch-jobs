package com.pilaka.springjwt.service;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pilaka.springjwt.entity.Employee;
import com.pilaka.springjwt.entity.Users;
import com.pilaka.springjwt.repository.EmployeeRepository;
import com.pilaka.springjwt.service.Gender;

@Service
public class EmployeeService {

	
	@Autowired
	EmployeeRepository repo;
	
	
	public List<Employee>listEmployees()
	{
	return repo.findAll();
		
	}


	public void addEmployee(Employee employee) {
	repo.save(employee);
		
	}


}
