package com.kodlamaio.kodlamaio.business.abstracts;

import java.util.List;

import com.kodlamaio.kodlamaio.business.request.CreateEmployeeRequest;
import com.kodlamaio.kodlamaio.business.request.UpdateEmployeeRequest;
import com.kodlamaio.kodlamaio.business.response.CreateEmployeeResponse;
import com.kodlamaio.kodlamaio.business.response.GetAllEmployeeResponse;
import com.kodlamaio.kodlamaio.business.response.GetEmployeeResponse;
import com.kodlamaio.kodlamaio.business.response.UpdateEmployeeResponse;
import com.kodlamaio.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.Result;


public interface EmployeeService {

	Result delete(int id);
	DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest);
	DataResult<List<GetAllEmployeeResponse>> getAll();
	DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest);
	DataResult<GetEmployeeResponse> getById(int id);
}
