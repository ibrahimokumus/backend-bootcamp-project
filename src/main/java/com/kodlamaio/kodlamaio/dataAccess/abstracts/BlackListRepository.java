package com.kodlamaio.kodlamaio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.kodlamaio.entity.user.BlackList;

public interface BlackListRepository  extends JpaRepository<BlackList, Integer>{
	
	BlackList findByApplicantId(int applicantId);
	boolean existsBlacklistByApplicantId(int id);
	

}
