package com.kodlamaio.kodlamaio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.kodlamaio.entity.user.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findEmployeeByNationalIdentity(String nationalIdentity);
	Employee findById(int id);
}
