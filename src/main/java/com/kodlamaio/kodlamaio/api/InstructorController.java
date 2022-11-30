package com.kodlamaio.kodlamaio.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.kodlamaio.business.abstracts.InstructorService;
import com.kodlamaio.kodlamaio.business.request.CreateInstructorRequest;
import com.kodlamaio.kodlamaio.business.request.UpdateInstructorRequest;
import com.kodlamaio.kodlamaio.business.response.CreateInstructorResponse;
import com.kodlamaio.kodlamaio.business.response.GetAllInstructorResponse;
import com.kodlamaio.kodlamaio.business.response.GetInstructorResponse;
import com.kodlamaio.kodlamaio.business.response.UpdateInstructorResponse;
import com.kodlamaio.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.Result;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
	private InstructorService instructorService;
	
	
	@GetMapping
	public DataResult<List<GetAllInstructorResponse>> getAll(){
		return this.instructorService.getAll();
	}
	
	@GetMapping("/{id}")
	public DataResult<GetInstructorResponse> getById(@PathVariable int id){
		return this.instructorService.getById(id);
	}
	@PostMapping()
	public DataResult<CreateInstructorResponse> add(@RequestBody CreateInstructorRequest createInstructorRequest) {
		return this.instructorService.add(createInstructorRequest);
	}
	@PutMapping()
	public DataResult<UpdateInstructorResponse> update(@RequestBody UpdateInstructorRequest updateInstructorRequest) {
		return this.instructorService.update(updateInstructorRequest);
	}
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.instructorService.delete(id);
	}
}
