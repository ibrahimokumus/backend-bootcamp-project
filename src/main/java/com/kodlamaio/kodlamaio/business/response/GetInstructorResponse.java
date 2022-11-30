package com.kodlamaio.kodlamaio.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class GetInstructorResponse {
	private int id;
	private String about;
	private String firstName;
	private String lastName;
	private String email;
	private String companyName;

}
