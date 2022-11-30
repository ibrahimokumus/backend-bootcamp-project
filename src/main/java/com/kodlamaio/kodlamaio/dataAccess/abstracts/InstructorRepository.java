package com.kodlamaio.kodlamaio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.kodlamaio.entity.user.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

	Instructor findInstructorByNationalIdentity(String nationalIdentity);
	Instructor findById(int id);
}
