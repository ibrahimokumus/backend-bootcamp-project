package com.kodlamaio.kodlamaio.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class UpdateApplicationRequest {
	
	private int id;
	private String name;
	private int applicantId;
	private int bootCampId;
}
