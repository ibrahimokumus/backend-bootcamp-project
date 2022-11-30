package com.kodlamaio.kodlamaio.business.response;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateBootCampResponse {
	
	private String name;
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    private Date dateStart;
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    private Date dateEnd;
    private int state;
    private int intructorId;

}
