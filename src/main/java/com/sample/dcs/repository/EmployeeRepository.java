package com.sample.dcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.dcs.entity.Employee;

/**
 * The Interface EmployeeRepository.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
