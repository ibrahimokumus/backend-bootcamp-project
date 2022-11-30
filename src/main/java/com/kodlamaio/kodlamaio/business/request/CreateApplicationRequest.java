package com.kodlamaio.kodlamaio.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CreateApplicationRequest {
	
	private int applicantId;
	private int bootCampId;

}
