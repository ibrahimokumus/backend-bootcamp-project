package com.kodlamaio.kodlamaio.business.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateBlackListResponse {
	
	private int id;
    private int applicantId;
    private LocalDate date;
    private String reason;
	

}
