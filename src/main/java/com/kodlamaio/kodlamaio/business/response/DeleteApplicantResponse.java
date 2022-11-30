package com.kodlamaio.kodlamaio.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DeleteApplicantResponse {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String about;

}
