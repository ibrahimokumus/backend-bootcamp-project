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

import com.kodlamaio.kodlamaio.business.abstracts.ApplicantService;
import com.kodlamaio.kodlamaio.business.request.CreateApplicantRequest;
import com.kodlamaio.kodlamaio.business.request.UpdateApplicantRequest;
import com.kodlamaio.kodlamaio.business.response.CreateApplicantResponse;
import com.kodlamaio.kodlamaio.business.response.GetAllApplicantResponse;
import com.kodlamaio.kodlamaio.business.response.GetApplicantResponse;
import com.kodlamaio.kodlamaio.business.response.UpdateApplicantResponse;
import com.kodlamaio.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.Result;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {
	
	private ApplicantService applicantService;
	
	@GetMapping
	public DataResult<List<GetAllApplicantResponse>> getAll(){
		return this.applicantService.getAll();
	}
	@GetMapping("/{id}")
	public DataResult<GetApplicantResponse> getById(@PathVariable int id) {
		return this.applicantService.getById(id);
	}
	@PostMapping()
	public DataResult <CreateApplicantResponse> add(@RequestBody CreateApplicantRequest createApplicantRequest) {
		return this.applicantService.add(createApplicantRequest);
	}
	
	@PutMapping()
	public DataResult <UpdateApplicantResponse>update(@RequestBody UpdateApplicantRequest updateApplicantRequest) {
		return this.applicantService.update(updateApplicantRequest);
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.applicantService.delete(id);
	}
	
	
	
}
