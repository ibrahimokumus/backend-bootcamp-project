package com.kodlamaio.kodlamaio.business.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateInstructorRequest {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String companyName;
	private String nationalIdentity;
	private Date dateOfBirth;
}
