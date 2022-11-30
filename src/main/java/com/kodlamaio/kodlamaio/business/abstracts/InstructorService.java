package com.kodlamaio.kodlamaio.business.abstracts;

import java.util.List;

import com.kodlamaio.kodlamaio.business.request.CreateInstructorRequest;
import com.kodlamaio.kodlamaio.business.request.UpdateInstructorRequest;
import com.kodlamaio.kodlamaio.business.response.CreateInstructorResponse;
import com.kodlamaio.kodlamaio.business.response.GetAllInstructorResponse;
import com.kodlamaio.kodlamaio.business.response.GetInstructorResponse;
import com.kodlamaio.kodlamaio.business.response.UpdateInstructorResponse;
import com.kodlamaio.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.Result;

public interface InstructorService {
	
	
	
	Result delete(int id);
	DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest);
	DataResult<List<GetAllInstructorResponse>> getAll();
	DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest);
	DataResult<GetInstructorResponse> getById(int id);
	
}
