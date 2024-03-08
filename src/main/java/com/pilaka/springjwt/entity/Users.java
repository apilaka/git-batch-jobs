package com.pilaka.springjwt.entity;

import java.util.UUID;


import org.springframework.stereotype.Component;

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
@Component

@Entity
@Table(name = "users", schema = "INVENTORY1")
@Embeddable
public class Users {
	
	
	@Id
	@Column
 
	@GeneratedValue(generator="seqGen2")
	@SequenceGenerator(name="seqGen2",sequenceName="users_seq_id", allocationSize=1)
	private long userId;	
	@Column
	private String userName;
	@Column
	private String email;
	@Column
	private Gender gender;


	

}
