package com.pilaka.springjwt.config;

import org.springframework.batch.item.ItemProcessor;
import com.pilaka.springjwt.entity.Employee;
public class EmployeeProcesser implements ItemProcessor<Employee, Employee> {
	@Override
	public Employee process(Employee employee) throws Exception {
		return employee;
	}

}
