package com.kodlamaio.kodlamaio.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateEmployeeResponse {
	
	private int id;
	private String position;
	private String firstName;
	private String lastName;
	private String email;
	

}
