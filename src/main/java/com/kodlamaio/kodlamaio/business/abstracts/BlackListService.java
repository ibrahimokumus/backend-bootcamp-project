package com.kodlamaio.kodlamaio.business.abstracts;

import java.util.List;

import com.kodlamaio.kodlamaio.business.request.CreateBlackListRequest;
import com.kodlamaio.kodlamaio.business.request.UpdateBlackListRequest;
import com.kodlamaio.kodlamaio.business.response.CreateBlackListResponse;
import com.kodlamaio.kodlamaio.business.response.GetAllBlackListResponse;
import com.kodlamaio.kodlamaio.business.response.GetBlackListResponse;
import com.kodlamaio.kodlamaio.business.response.UpdateBlackListResponse;
import com.kodlamaio.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.Result;

public interface BlackListService {
	
	Result delete(int id);
    DataResult<CreateBlackListResponse> add(CreateBlackListRequest createBlackListRequest);
    DataResult<List<GetAllBlackListResponse>> getAll();
    DataResult<UpdateBlackListResponse> Update (UpdateBlackListRequest updateBlackListRequest);
    DataResult<GetBlackListResponse> getById(int id);

    void checkIfApplicantIsInBlacklist(int applicantId);
	

}
