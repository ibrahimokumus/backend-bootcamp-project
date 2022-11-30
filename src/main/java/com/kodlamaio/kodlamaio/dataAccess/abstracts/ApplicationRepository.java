package com.kodlamaio.kodlamaio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.kodlamaio.entity.user.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

	Application findById(int id);
}
