package com.kodlamaio.kodlamaio.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeResponse {
	private int id;
	private String about;
	private String firstName;
	private String lastName;
	private String email;

}
