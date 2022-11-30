package com.kodlamaio.kodlamaio.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.kodlamaio.business.abstracts.EmployeeService;
import com.kodlamaio.kodlamaio.business.request.CreateEmployeeRequest;
import com.kodlamaio.kodlamaio.business.request.UpdateEmployeeRequest;
import com.kodlamaio.kodlamaio.business.response.CreateEmployeeResponse;
import com.kodlamaio.kodlamaio.business.response.GetAllEmployeeResponse;
import com.kodlamaio.kodlamaio.business.response.GetEmployeeResponse;
import com.kodlamaio.kodlamaio.business.response.UpdateEmployeeResponse;
import com.kodlamaio.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.Result;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@GetMapping("/{id}")
	public DataResult<GetEmployeeResponse> getById(@PathVariable int id){
		return this.employeeService.getById(id);
	}
	
	@GetMapping
	public DataResult <List<GetAllEmployeeResponse>> getAll(){
		
		return this.employeeService.getAll();
	}
	
	@PostMapping()
	public DataResult<CreateEmployeeResponse> add(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
		return this.employeeService.add(createEmployeeRequest);
	}
	@PutMapping()
	public DataResult<UpdateEmployeeResponse> update(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
		return this.employeeService.update(updateEmployeeRequest);
	}
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.employeeService.delete(id);
	}

}
