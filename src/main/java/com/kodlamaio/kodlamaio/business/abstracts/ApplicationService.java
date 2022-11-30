package com.kodlamaio.kodlamaio.business.abstracts;

import java.util.List;

import com.kodlamaio.kodlamaio.business.request.CreateApplicationRequest;
import com.kodlamaio.kodlamaio.business.request.UpdateApplicationRequest;
import com.kodlamaio.kodlamaio.business.response.CreateApplicationResponse;
import com.kodlamaio.kodlamaio.business.response.GetAllApplicationResponses;
import com.kodlamaio.kodlamaio.business.response.GetApplicationResponses;
import com.kodlamaio.kodlamaio.business.response.UpdateApplicationResponse;
import com.kodlamaio.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.Result;

public interface ApplicationService {

	Result delete(int id);
    DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest);
    DataResult<List<GetAllApplicationResponses>> GetAll();
    DataResult<UpdateApplicationResponse> update (UpdateApplicationRequest updateApplicationRequest);
    DataResult<GetApplicationResponses> getById(int id);
}
