package com.kodlamaio.kodlamaio.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetAllApplicantResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String about;
	

}
