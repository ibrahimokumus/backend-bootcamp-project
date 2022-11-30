package com.kodlamaio.kodlamaio.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="instructors")
@Data
public class Instructor extends User {
	
	
	
	@Column(name="companyName")
	private String companyName;

	
	
	
}
