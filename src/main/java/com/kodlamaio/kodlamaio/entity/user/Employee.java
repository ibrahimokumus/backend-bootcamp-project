package com.kodlamaio.kodlamaio.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
@Entity



public class Employee extends User{
	
	

	@Column(name="position")
	private String position;
	
	
}
