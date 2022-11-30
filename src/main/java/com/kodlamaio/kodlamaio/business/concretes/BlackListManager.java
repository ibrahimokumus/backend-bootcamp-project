package com.kodlamaio.kodlamaio.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.kodlamaio.business.abstracts.ApplicantService;
import com.kodlamaio.kodlamaio.business.abstracts.BlackListService;
import com.kodlamaio.kodlamaio.business.contstants.Messages;
import com.kodlamaio.kodlamaio.business.request.CreateBlackListRequest;
import com.kodlamaio.kodlamaio.business.request.UpdateBlackListRequest;
import com.kodlamaio.kodlamaio.business.response.CreateBlackListResponse;
import com.kodlamaio.kodlamaio.business.response.GetAllBlackListResponse;
import com.kodlamaio.kodlamaio.business.response.GetBlackListResponse;
import com.kodlamaio.kodlamaio.business.response.UpdateBlackListResponse;
import com.kodlamaio.kodlamaio.core.utilities.exceptions.BusinessException;
import com.kodlamaio.kodlamaio.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.Result;
import com.kodlamaio.kodlamaio.core.utilities.results.SuccessDataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.SuccessResult;
import com.kodlamaio.kodlamaio.dataAccess.abstracts.ApplicationRepository;
import com.kodlamaio.kodlamaio.dataAccess.abstracts.BlackListRepository;
import com.kodlamaio.kodlamaio.entity.user.BlackList;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BlackListManager implements BlackListService{

	private BlackListRepository blackListRepository;
    private ApplicationRepository applicationReposities;
    private ModelMapperService modelMapperService;
    private ApplicantService applicantService;
	@Override
	public Result delete(int id) {
		checkIfBlacklistExistById(id);
        this.blackListRepository.deleteById(id);
        return new SuccessResult(Messages.BlackListDeleted);
	}

	@Override
	public DataResult<CreateBlackListResponse> add(CreateBlackListRequest createBlackListRequest) {
		checkIfApplicantIsInBlacklist(createBlackListRequest.getApplicantId());
        applicantService.checkIfUserIsApplicant(createBlackListRequest.getApplicantId());
        BlackList blacklist = this.modelMapperService.forRequest().map(createBlackListRequest, BlackList.class);
        this.blackListRepository.save(blacklist);

        CreateBlackListResponse createBlacklistResponse = this.modelMapperService.forResponse().map(blacklist,
                CreateBlackListResponse.class);
        return new SuccessDataResult<>(createBlacklistResponse, Messages.BlackListCreated);
	}

	@Override
	public DataResult<List<GetAllBlackListResponse>> getAll() {
		List<BlackList> blacklist = this.blackListRepository.findAll();
        List<GetAllBlackListResponse> response = blacklist.stream()
                .map(blacklists -> this.modelMapperService.forResponse().map(blacklists, GetAllBlackListResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllBlackListResponse>>(response);
	}

	@Override
	public DataResult<UpdateBlackListResponse> Update(UpdateBlackListRequest updateBlackListRequest) {
		checkIfBlacklistExistById(updateBlackListRequest.getId());
        BlackList blackList = this.modelMapperService.forRequest().map(updateBlackListRequest, BlackList.class);
        this.blackListRepository.save(blackList);
        UpdateBlackListResponse updateBlacklistResponse = this.modelMapperService.forResponse().map(blackList,
                UpdateBlackListResponse.class);
        return new SuccessDataResult<>(updateBlacklistResponse, Messages.BlackListUpdated);
	}

	@Override
	public DataResult<GetBlackListResponse> getById(int id) {
		BlackList blacklist = this.blackListRepository.findById(id).orElse(null);
        GetBlackListResponse response = this.modelMapperService.forResponse().map(blacklist,
                GetBlackListResponse.class);
        return new SuccessDataResult<>(response);
	}

	@Override
	public void checkIfApplicantIsInBlacklist(int applicantId) {
		
		if (!blackListRepository.existsById(applicantId)) {
            applicationReposities.deleteById(applicantId);
            throw new BusinessException(Messages.BlackListNotExists);
        }
		
	}

	private void checkIfBlacklistExistById(int id) {
        if (!blackListRepository.existsById(id)) {
            applicationReposities.deleteById(id);
            throw new BusinessException(Messages.BlackListNotExists);
        }
    }
	
	
}
