package com.sample.dcs.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sample.dcs.exception.ResourceNotFoundException;
import com.sample.dcs.model.EmployeeDto;

// TODO: Auto-generated Javadoc
/**
 * The Interface EmployeeCacheService.
 */
public interface EmployeeCacheService {

	/**
	 * Gets the all employees.
	 *
	 * @param pageable the pageable
	 * @return the all employees
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	Page<EmployeeDto> getAllEmployees(final Pageable pageable) throws ResourceNotFoundException;

	/**
	 * Gets the employee by id.
	 *
	 * @param employeeId the employee id
	 * @return the employee by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	EmployeeDto getEmployeeById(final Long employeeId) throws ResourceNotFoundException;

	/**
	 * Update employee.
	 *
	 * @param employeeDetails the employee details
	 * @return the employee dto
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	EmployeeDto updateEmployee(final EmployeeDto employeeDetails)throws ResourceNotFoundException;
	
	/**
	 * Evict all employee cache.
	 */
	void evictAllEmployeeCache();

}
