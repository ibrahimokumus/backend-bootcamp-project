package com.kodlamaio.kodlamaio.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.kodlamaio.business.abstracts.ApplicantService;
import com.kodlamaio.kodlamaio.business.abstracts.ApplicationService;
import com.kodlamaio.kodlamaio.business.abstracts.BlackListService;
import com.kodlamaio.kodlamaio.business.abstracts.BootCampService;
import com.kodlamaio.kodlamaio.business.contstants.Messages;
import com.kodlamaio.kodlamaio.business.request.CreateApplicationRequest;
import com.kodlamaio.kodlamaio.business.request.UpdateApplicationRequest;
import com.kodlamaio.kodlamaio.business.response.CreateApplicationResponse;
import com.kodlamaio.kodlamaio.business.response.GetAllApplicationResponses;
import com.kodlamaio.kodlamaio.business.response.GetApplicationResponses;
import com.kodlamaio.kodlamaio.business.response.UpdateApplicationResponse;
import com.kodlamaio.kodlamaio.core.utilities.exceptions.BusinessException;
import com.kodlamaio.kodlamaio.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.Result;
import com.kodlamaio.kodlamaio.core.utilities.results.SuccessDataResult;
import com.kodlamaio.kodlamaio.core.utilities.results.SuccessResult;
import com.kodlamaio.kodlamaio.dataAccess.abstracts.ApplicationRepository;
import com.kodlamaio.kodlamaio.entity.user.Application;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class ApplicationManager  implements ApplicationService{

	private ApplicationRepository applicationRepository;
    private BlackListService blackListService;
    private ApplicantService applicantService;
    private BootCampService bootCampService;
    private ModelMapperService modelMapperService;
	@Override
	public Result delete(int id) {
		checkIfApplicationExistById(id);
        this.applicationRepository.deleteById(id);
        return new SuccessResult(Messages.ApplicationDeleted);
	}

	@Override
	public DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest) {
		checkIfApplicantExists(createApplicationRequest.getApplicantId());
        checkIfBootcampExists(createApplicationRequest.getBootCampId());
        blackListService.checkIfApplicantIsInBlacklist(createApplicationRequest.getApplicantId());
        Application application = this.modelMapperService.forRequest().map(createApplicationRequest,
                Application.class);
        this.applicationRepository.save(application);

        CreateApplicationResponse createApplicationResponse = this.modelMapperService.forResponse().map(application,
                CreateApplicationResponse.class);
        return new SuccessDataResult<CreateApplicationResponse>(createApplicationResponse, Messages.ApplicationCreated);
	}

	@Override
	public DataResult<List<GetAllApplicationResponses>> GetAll() {
		List<Application> applications = this.applicationRepository.findAll();
        List<GetAllApplicationResponses> response = applications.stream().map(application -> this.modelMapperService
                .forResponse().map(applications, GetAllApplicationResponses.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllApplicationResponses>>(response);
	}

	@Override
	public DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest) {
		checkIfApplicantExists(updateApplicationRequest.getApplicantId());
        checkIfBootcampExists(updateApplicationRequest.getBootCampId());
        Application application = this.modelMapperService.forRequest().map(updateApplicationRequest,
                Application.class);
        this.applicationRepository.save(application);
        UpdateApplicationResponse updateApplicationResponse = this.modelMapperService.forResponse().map(application,
                UpdateApplicationResponse.class);
        return new SuccessDataResult<UpdateApplicationResponse>(updateApplicationResponse, Messages.ApplicationUpdated);
	}

	@Override
	public DataResult<GetApplicationResponses> getById(int id) {
		Application application = this.applicationRepository.findById(id);
        GetApplicationResponses response = this.modelMapperService.forResponse().map(application,
                GetApplicationResponses.class);
        return new SuccessDataResult<GetApplicationResponses>(response);
	}

	private void checkIfApplicationExistById(int id) {
        if (applicationRepository.findById(id) == null)
            throw new BusinessException(Messages.ApplicationExists);
    }

    private void checkIfApplicantExists(int applicantId) {
        var result = applicantService.getById(applicantId);
        if (result == null) {
            throw new BusinessException(Messages.ApplicantExists);
        }

    }

    private void checkIfBootcampExists(int bootcampId) {
        var result = bootCampService.getById(bootcampId);
        if (result==null) {
            throw new BusinessException(Messages.BootCampExists);
        }
    }
	
	
	
}
