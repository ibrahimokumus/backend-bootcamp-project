package com.kodlamaio.kodlamaio.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.kodlamaio.business.abstracts.ApplicantService;
import com.kodlamaio.kodlamaio.business.contstants.Messages;
import com.kodlamaio.kodlamaio.business.request.CreateApplicantRequest;
import com.kodlamaio.kodlamaio.business.request.UpdateApplicantRequest;
import com.kodlamaio.kodlamaio.business.response.CreateApplicantResponse;
import com.kodlamaio.kodlamaio.business.response.GetAllApplicantResponse;
import com.kodlamaio.kodlamaio.business.response.GetApplicantResponse;
import com.kodlamaio.kodlamaio.business.response.UpdateApplicantResponse;
import com.kodlamaio.kodlamaio.core.utilities.exceptions.BusinessException;
import com.kodlamaio.kodlamaio.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.Result;
import com.kodlamaio.kodlamaio.core.utilities.results.SuccessDataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.SuccessResult;
import com.kodlamaio.kodlamaio.dataAccess.abstracts.ApplicantRepository;
import com.kodlamaio.kodlamaio.entity.user.Applicant;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class ApplicantManager implements ApplicantService {

	private ApplicantRepository applicantRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public Result delete(int id) {
		checkIfApplicantExistsById(id);
		 this.applicantRepository.findById(id);
		return new SuccessResult(Messages.ApplicantDeleted);
	}
	@Override
	public DataResult<List<GetAllApplicantResponse>> getAll() {
		
		List<Applicant> applicants=this.applicantRepository.findAll();
		List<GetAllApplicantResponse> response=applicants.stream().map(applicant->this.modelMapperService.forResponse().map(applicants, GetAllApplicantResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicantResponse>>(response);
	}
	@Override
	public DataResult<GetApplicantResponse> getById(int id) {
		
		
		Applicant applicant=this.applicantRepository.findById(id).get();		
		GetApplicantResponse response =this.modelMapperService.forResponse().map(applicant, GetApplicantResponse.class);
		return new SuccessDataResult<GetApplicantResponse>(response);
	}
	@Override
	public DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest) {
		checkIfApplicantExistsByNationalIdentity(createApplicantRequest.getNationalIdentity());
		Applicant applicant=this.modelMapperService.forRequest().map(createApplicantRequest, Applicant.class);
		this.applicantRepository.save(applicant);
		CreateApplicantResponse response=this.modelMapperService.forResponse().map(applicant, CreateApplicantResponse.class);
		
		
		return new SuccessDataResult<CreateApplicantResponse>(response,Messages.ApplicantCreated);
	}
	@Override
	public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest) {
		checkIfApplicantExistsById(updateApplicantRequest.getId());
		Applicant applicant = this.modelMapperService.forRequest().map(updateApplicantRequest, Applicant.class);
		this.applicantRepository.save(applicant);
		UpdateApplicantResponse response = this.modelMapperService.forResponse().map(applicant, UpdateApplicantResponse.class);
		
		return new SuccessDataResult<UpdateApplicantResponse>(response,Messages.ApplicantUpdated);
	}
	
	private void checkIfApplicantExistsByNationalIdentity(String nationalIdentity) {
		if(applicantRepository.findApplicantByNationalIdentity(nationalIdentity)!=null)
			throw new BusinessException(Messages.ApplicantExists);
	}
	
	private void checkIfApplicantExistsById(int id) {
		
		if(applicantRepository.existsById(id))
		{		
			throw new BusinessException(Messages.EmployeeNotFound);
		}
	}
	@Override
	public void checkIfUserIsApplicant(int applicantId) {
		if (!applicantRepository.existsById(applicantId)) {
            throw new BusinessException(Messages.IsNotApplicant);
		
		}
	
	}
}
