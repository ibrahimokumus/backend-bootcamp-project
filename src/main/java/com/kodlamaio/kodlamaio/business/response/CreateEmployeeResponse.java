package com.kodlamaio.kodlamaio.business.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateEmployeeResponse {
	
	private int id;
	private String position;
	private String firstName;
	private String lastName;
	private String email;
	private String nationalIdentity;
	private Date dateOfBirth;

}
