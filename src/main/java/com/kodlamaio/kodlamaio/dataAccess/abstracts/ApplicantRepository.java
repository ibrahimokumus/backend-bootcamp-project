package com.kodlamaio.kodlamaio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.kodlamaio.entity.user.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer>{

	Applicant findApplicantByNationalIdentity(String nationalIdentity);
	
	
}
