package com.kodlamaio.kodlamaio.business.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateApplicantRequest {
	private int id;
	private String about;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String nationalIdentity;
	private Date dateOfBirth;

}
