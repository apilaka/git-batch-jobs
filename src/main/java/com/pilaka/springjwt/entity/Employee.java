package com.pilaka.springjwt.entity;

import java.util.UUID;



import com.pilaka.springjwt.service.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "employee", schema = "INVENTORY1")
@Embeddable
public class Employee {
	
	

	@Id
	@Column

	@GeneratedValue(generator="seqGen")
	@SequenceGenerator(name="seqGen",sequenceName="employee_seq_id", allocationSize=1)
	private long employeeId;
	@Column
	private String employeeName;
	@Column
	private String email;
	@Column
	private String gender;


}
