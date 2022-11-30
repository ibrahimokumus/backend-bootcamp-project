package com.kodlamaio.kodlamaio.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name="applicants")
public class Applicant extends User {
	

	
	@Column(name="about")
	private String about;
	
	
	
}
