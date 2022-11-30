package com.kodlamaio.kodlamaio.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.kodlamaio.business.abstracts.InstructorService;
import com.kodlamaio.kodlamaio.business.contstants.Messages;
import com.kodlamaio.kodlamaio.business.request.CreateInstructorRequest;
import com.kodlamaio.kodlamaio.business.request.UpdateInstructorRequest;
import com.kodlamaio.kodlamaio.business.response.CreateInstructorResponse;
import com.kodlamaio.kodlamaio.business.response.GetAllInstructorResponse;
import com.kodlamaio.kodlamaio.business.response.GetInstructorResponse;
import com.kodlamaio.kodlamaio.business.response.UpdateInstructorResponse;
import com.kodlamaio.kodlamaio.core.utilities.exceptions.BusinessException;
import com.kodlamaio.kodlamaio.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.Result;
import com.kodlamaio.kodlamaio.core.utilities.results.SuccessDataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.SuccessResult;
import com.kodlamaio.kodlamaio.dataAccess.abstracts.InstructorRepository;
import com.kodlamaio.kodlamaio.entity.user.Instructor;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService{

	private InstructorRepository instructorRepository;
	private ModelMapperService modelMapperService;
	
	public Result delete(int id) {
		checkIfInstructorExistsById(id);
		this.instructorRepository.deleteById(id);
		
		return new SuccessResult(Messages.InstructorDeleted);
	}
	@Override
	public DataResult<List<GetAllInstructorResponse>> getAll() {
		List<Instructor> instructors = this.instructorRepository.findAll();
		// stream tek tek instractor nesnelerini gezer
		List<GetAllInstructorResponse> response = instructors.stream().
				map(instructor->this.modelMapperService.forResponse().
				map(instructor, GetAllInstructorResponse.class)).collect(Collectors.toList());
		
		
		return new SuccessDataResult<List<GetAllInstructorResponse>>(response);
	}
	@Override
	public DataResult<GetInstructorResponse> getById(int id) {
		
		Instructor instructor= this.instructorRepository.findById(id);
		GetInstructorResponse response= this.modelMapperService.forResponse().map(instructor, GetInstructorResponse.class);
		return new SuccessDataResult<GetInstructorResponse>(response);
	}
	@Override
	public DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest) {
		checkIfInstructorExistsByNationalIdentity(createInstructorRequest.getNationalIdentity());
		Instructor instructor=this.modelMapperService.forRequest().map(createInstructorRequest,Instructor.class);
		this.instructorRepository.save(instructor);
		CreateInstructorResponse createInstructorResponse=this.modelMapperService.forResponse().map(instructor, CreateInstructorResponse.class);
		
		return new SuccessDataResult<CreateInstructorResponse>(createInstructorResponse,Messages.InstructorCreated);
	}
	@Override
	public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest) {
		checkIfInstructorExistsById(updateInstructorRequest.getId());
		Instructor instructor=this.modelMapperService.forRequest().map(updateInstructorRequest,Instructor.class);
		this.instructorRepository.save(instructor);
		UpdateInstructorResponse response = this.modelMapperService.forResponse().map(instructor, UpdateInstructorResponse.class);
		return new SuccessDataResult<UpdateInstructorResponse>(response,Messages.InstructorUpdated);
	}
	
	private void checkIfInstructorExistsByNationalIdentity(String nationalIdentity) {
		
		if(instructorRepository.findInstructorByNationalIdentity(nationalIdentity)!=null)
			throw new BusinessException(Messages.InstructorExists);
		
		}
	private void checkIfInstructorExistsById(int id) {
		if(instructorRepository.findById(id)==null) {
			throw new BusinessException(Messages.InstructorNotFound);
		}
			
	}
	
}
