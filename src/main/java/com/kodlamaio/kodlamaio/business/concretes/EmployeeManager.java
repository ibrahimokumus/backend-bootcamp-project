package com.kodlamaio.kodlamaio.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.kodlamaio.business.abstracts.EmployeeService;
import com.kodlamaio.kodlamaio.business.contstants.Messages;
import com.kodlamaio.kodlamaio.business.request.CreateEmployeeRequest;
import com.kodlamaio.kodlamaio.business.request.UpdateEmployeeRequest;
import com.kodlamaio.kodlamaio.business.response.CreateEmployeeResponse;
import com.kodlamaio.kodlamaio.business.response.GetAllEmployeeResponse;
import com.kodlamaio.kodlamaio.business.response.GetEmployeeResponse;
import com.kodlamaio.kodlamaio.business.response.UpdateEmployeeResponse;
import com.kodlamaio.kodlamaio.core.utilities.exceptions.BusinessException;
import com.kodlamaio.kodlamaio.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.Result;
import com.kodlamaio.kodlamaio.core.utilities.results.SuccessDataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.SuccessResult;
import com.kodlamaio.kodlamaio.dataAccess.abstracts.EmployeeRepository;
import com.kodlamaio.kodlamaio.entity.user.Employee;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class EmployeeManager implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public Result delete(int id) {
		checkIfEmployeeExistsById(id);
		this.employeeRepository.deleteById(id);
		
		return new SuccessResult(Messages.EmployeeDeleted);
	}
	@Override
	public DataResult<List<GetAllEmployeeResponse>> getAll() {
		List<Employee> employees =this.employeeRepository.findAll();
		List<GetAllEmployeeResponse> response =employees.stream().map(employee->this.modelMapperService.forResponse().map(employee, GetAllEmployeeResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllEmployeeResponse>>(response);
	}
	@Override
	public DataResult<GetEmployeeResponse> getById(int id) {
		
		Employee employee= this.employeeRepository.findById(id);
		GetEmployeeResponse response= this.modelMapperService.forResponse().map(employee, GetEmployeeResponse.class);
		return new SuccessDataResult<GetEmployeeResponse>(response);
	}
	@Override
	public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest) {
		checkIfEmployeeExistsByNationalIdentity(createEmployeeRequest.getNationalIdentity());
		Employee employee=this.modelMapperService.forRequest().map(createEmployeeRequest,Employee.class);
		this.employeeRepository.save(employee);
		CreateEmployeeResponse response=this.modelMapperService.forResponse().map(employee, CreateEmployeeResponse.class);
		return new SuccessDataResult<CreateEmployeeResponse>(response,Messages.EmployeeCreated);
	}
	@Override
	public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest) {
		checkIfEmployeeExistsById(updateEmployeeRequest.getId());
		Employee employee=this.modelMapperService.forRequest().map(updateEmployeeRequest,Employee.class);
		this.employeeRepository.save(employee);
		UpdateEmployeeResponse response = this.modelMapperService.forResponse().map(employee, UpdateEmployeeResponse.class);
		
		return new SuccessDataResult<UpdateEmployeeResponse>(response,Messages.EmployeeUpdated);
	}
	
	private void checkIfEmployeeExistsByNationalIdentity(String nationalIdentity) {
		if(employeeRepository.findEmployeeByNationalIdentity(nationalIdentity)!=null) {
			throw new BusinessException(Messages.EmployeeExists);
		}
	}
	
	private void checkIfEmployeeExistsById(int id) {
		if(employeeRepository.findById(id) == null)
			throw new BusinessException(Messages.EmployeeNotFound);	
		
		
	}
}
