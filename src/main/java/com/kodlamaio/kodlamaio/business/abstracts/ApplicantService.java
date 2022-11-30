package com.kodlamaio.kodlamaio.business.abstracts;

import java.util.List;

import com.kodlamaio.kodlamaio.business.request.CreateApplicantRequest;
import com.kodlamaio.kodlamaio.business.request.UpdateApplicantRequest;
import com.kodlamaio.kodlamaio.business.response.CreateApplicantResponse;
import com.kodlamaio.kodlamaio.business.response.GetAllApplicantResponse;
import com.kodlamaio.kodlamaio.business.response.GetApplicantResponse;
import com.kodlamaio.kodlamaio.business.response.UpdateApplicantResponse;
import com.kodlamaio.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.Result;

public interface ApplicantService {

	
	Result delete(int id);
	DataResult<List<GetAllApplicantResponse>> getAll();
	
	DataResult<GetApplicantResponse> getById(int id);
	DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest);
	DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest);
	//void checkIfApplicantExistsByNationalIdentity(String nationalIdentity);
	
	void checkIfUserIsApplicant(int applicantId);
	
	
	
	
}
