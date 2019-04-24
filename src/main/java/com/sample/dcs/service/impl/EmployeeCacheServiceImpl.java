package com.sample.dcs.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sample.dcs.exception.ResourceNotFoundException;
import com.sample.dcs.model.EmployeeDto;
import com.sample.dcs.service.EmployeeCacheService;

/**
 * The Class EmployeeCacheServiceImpl.
 * 
 * @author sdash
 *
 */
@Service
public class EmployeeCacheServiceImpl implements EmployeeCacheService {

	/** The employee cache details. */
	@Autowired
	private EmployeeCacheDetails employeeCacheDetails;
	
	/* (non-Javadoc)
	 * @see com.sample.dcs.service.EmployeeCacheService#getAllEmployees(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<EmployeeDto> getAllEmployees(Pageable pageable) {
		final List<EmployeeDto> employeeList = employeeCacheDetails.getAllEmployees();

		final List<EmployeeDto> pageList = employeeList
				.stream().skip(pageable.getPageNumber() * pageable.getPageSize()).limit(pageable.getPageSize())
				.collect(Collectors.toList());

		return new PageImpl<EmployeeDto>(pageList, pageable, employeeList.size());
	}

	/* (non-Javadoc)
	 * @see com.sample.dcs.service.EmployeeCacheService#getEmployeeById(java.lang.Long)
	 */
	@Override
	public EmployeeDto getEmployeeById(final Long employeeId) throws ResourceNotFoundException {
		java.util.Optional<EmployeeDto> user = employeeCacheDetails.getAllEmployees().stream().filter(p -> p.getId().equals(employeeId)).findFirst();
		if (user.isPresent()) {
			return user.get();
		}
		throw new ResourceNotFoundException();
	}

	/* (non-Javadoc)
	 * @see com.sample.dcs.service.EmployeeCacheService#updateEmployee(com.sample.dcs.model.EmployeeDto)
	 */
	@Override
	public EmployeeDto updateEmployee(@Valid final EmployeeDto employeeDetails) throws ResourceNotFoundException {
		final EmployeeDto employee = getEmployeeById(employeeDetails.getId());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		return employeeCacheDetails.updateEmployee(employee.getId(), employeeDetails);
	}

	/* (non-Javadoc)
	 * @see com.sample.dcs.service.EmployeeCacheService#evictAllEmployeeCache()
	 */
	@Override
	public void evictAllEmployeeCache() {
		employeeCacheDetails.evictAllEmployeeCache();
	}
}
