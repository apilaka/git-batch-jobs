package com.pilaka.springjwt.dto;

import org.springframework.stereotype.Service;

import com.pilaka.springjwt.entity.Employee;

@Service
public class EmployeeMapper {

	public Employee toEmployee(EmployeeDTO dto) {
		if(null==dto)
		{
			throw new NullPointerException("employee DTO is null");
			
		}
		Employee employee = new Employee();
		employee.setEmployeeId(dto.getEmployeeId());
		employee.setEmployeeName(dto.getEmployeeName());
		employee.setEmail(dto.getEmail());
		employee.setGender(dto.getGender());
		return employee;

	}

	public EmployeeDTO toEmployeeDTO(Employee employee)

	{
		long employee_id = employee.getEmployeeId();
		String employee_name = employee.getEmployeeName();
		String email = employee.getEmail();
		String gender = employee.getGender();

		return new EmployeeDTO(employee_id, employee_name, email, gender);

	}
}
