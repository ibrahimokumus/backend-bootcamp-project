package com.kodlamaio.kodlamaio.business.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class CreateEmployeeRequest {
	private String position;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String nationalIdentity;
	private Date dateOfBirth;

}
