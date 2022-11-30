package com.kodlamaio.kodlamaio.business.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CreateBootCampRequest {

	@NotNull(message = "this field is required")
    private String name;
    @NotNull(message = "this field is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyyy") 
    Date dateStart;
    @NotNull(message = "this field is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd/MM/yyyy") 
    private Date dateEnd;
    @NotNull(message = "this field is required")
    private int state;
    @NotNull(message = "this field is required")
    private int intructorId;
}
