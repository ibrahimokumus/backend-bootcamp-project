package com.kodlamaio.kodlamaio.business.abstracts;

import java.util.List;

import com.kodlamaio.kodlamaio.business.request.CreateBootCampRequest;
import com.kodlamaio.kodlamaio.business.request.UpdateBootCampRequest;
import com.kodlamaio.kodlamaio.business.response.CreateBootCampResponse;
import com.kodlamaio.kodlamaio.business.response.GetAllBootCampResponse;
import com.kodlamaio.kodlamaio.business.response.GetBootCampResponse;
import com.kodlamaio.kodlamaio.business.response.UpdateBootCampResponse;
import com.kodlamaio.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.Result;

public interface BootCampService {

	Result delete(int id);
    DataResult<CreateBootCampResponse> Add(CreateBootCampRequest createBootCampRequest);
    DataResult<List<GetAllBootCampResponse>> GetAll();
    DataResult<UpdateBootCampResponse> Update (UpdateBootCampRequest updateBootCampRequest);
    DataResult<GetBootCampResponse> getById(int id);
}
