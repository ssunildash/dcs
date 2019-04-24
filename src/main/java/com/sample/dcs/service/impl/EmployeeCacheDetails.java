package com.sample.dcs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.dcs.entity.Employee;
import com.sample.dcs.model.EmployeeDto;
import com.sample.dcs.repository.EmployeeRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeCacheDetails.
 */
@Service
@CacheConfig(cacheNames = { "employeeDetails" })
public class EmployeeCacheDetails {

	/** The employee repository. */
	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	@Cacheable(value = "employeeDetails")
	public List<EmployeeDto> getAllEmployees() {
		final List<Employee> employees = employeeRepository.findAll(Sort.by(Order.by("id")));
		return employees.stream().map(e -> {
			return EmployeeDto
					.builder().id(e.getId())//
					.firstName(e.getFirstName())//
					.lastName(e.getLastName())//
					.emailId(e.getLastName())//
					.build();
		}).collect(Collectors.toList());
	}
	
	/**
	 * Update employee.
	 *
	 * @param id the id
	 * @param employeeDetails the employee details
	 * @return the employee dto
	 */
	@CachePut(value = "employeeDetails", key = "#id")
	public EmployeeDto updateEmployee(final Long id, @Valid final EmployeeDto employeeDetails) {
		return employeeDetails;
	}

	/**
	 * Evict all employee cache.
	 */
	@CacheEvict(value = "employeeDetails", allEntries = true) // It will clear cache
	@Transactional(readOnly = true)
	public void evictAllEmployeeCache() {

	}
}
