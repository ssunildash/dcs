package com.sample.dcs.controller.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dcs.controller.EmployeeController;
import com.sample.dcs.exception.ResourceNotFoundException;
import com.sample.dcs.model.EmployeeDto;
import com.sample.dcs.service.EmployeeCacheService;

import io.swagger.annotations.Api;

/**
 * The Class EmployeeControllerImpl.
 */
@RestController
@Api(value = "Employee Management System", description = "Operations pertaining to Employee cache Management System", tags = "Employee Cache Management System")
public class EmployeeControllerImpl implements EmployeeController {

	/** The employee cache service. */
	@Autowired
	private EmployeeCacheService employeeCacheService;

	/* (non-Javadoc)
	 * @see com.sample.dcs.controller.EmployeeController#getAllEmployees(int, int)
	 */
	@Override
	public Page<EmployeeDto> getAllEmployees(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit) throws ResourceNotFoundException {
		
		Page<EmployeeDto> resultPage = employeeCacheService.getAllEmployees(PageRequest.of(page, limit));
		if (resultPage.getTotalElements() < (resultPage.getSize() * resultPage.getNumber())) {
			throw new ResourceNotFoundException();
		}
		return resultPage;
	}

	/* (non-Javadoc)
	 * @see com.sample.dcs.controller.EmployeeController#getEmployeeById(java.lang.Long)
	 */
	@Override
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") final Long employeeId) throws ResourceNotFoundException {
		Assert.notNull(employeeId, "employeeId can't be null");
		EmployeeDto employee = employeeCacheService.getEmployeeById(employeeId);
		return ResponseEntity.ok().body(employee);
	}

	/* (non-Javadoc)
	 * @see com.sample.dcs.controller.EmployeeController#updateEmployee(java.lang.Long, com.sample.dcs.model.EmployeeDto)
	 */
	@Override
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") final Long employeeId, @Valid @RequestBody final EmployeeDto employeeDetails)
			throws ResourceNotFoundException {
		Assert.notNull(employeeId, "employeeId can't be null");
		final EmployeeDto updatedEmployee = employeeCacheService.updateEmployee(employeeDetails);
		return ResponseEntity.ok(updatedEmployee);
	}
}
