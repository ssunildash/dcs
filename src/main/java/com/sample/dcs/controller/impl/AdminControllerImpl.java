package com.sample.dcs.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dcs.controller.AdminController;
import com.sample.dcs.service.EmployeeCacheService;

import io.swagger.annotations.Api;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminControllerImpl.
 */
@RestController
@Api(value = "admin Management System", description = "Operations pertaining to Admin : employee cache evict  Management System")
public class AdminControllerImpl implements AdminController {

	/** The employee cache service. */
	@Autowired
	private EmployeeCacheService employeeCacheService;

	/* (non-Javadoc)
	 * @see com.sample.dcs.controller.AdminController#evictEmployeeCache()
	 */
	@Override
	public void evictEmployeeCache() throws Exception {
		employeeCacheService.evictAllEmployeeCache();
	}
}
