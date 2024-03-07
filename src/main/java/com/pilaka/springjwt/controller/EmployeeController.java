package com.pilaka.springjwt.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pilaka.springjwt.entity.Employee;
import com.pilaka.springjwt.entity.Users;
import com.pilaka.springjwt.service.EmployeeService;
import com.pilaka.springjwt.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v3")
@EnableAutoConfiguration
@RequiredArgsConstructor
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private final JobLauncher jobLauncher;
	
	@Autowired
	private final Job job;
		
	@GetMapping("/listEmployees")
	public CompletableFuture<List<Employee>> listEmployees() {
		return CompletableFuture.completedFuture(employeeService.listEmployees());

	}

	@PostMapping("/loadEmployees")
	public void importEmployeesFromCSV() {
		JobParameters jobParameters = new JobParametersBuilder().addLong("startAt", System.currentTimeMillis())
				.toJobParameters();

		try {
			jobLauncher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException 
				| JobRestartException 
				| JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e)
		{
			e.printStackTrace();
		}
	}
}


