package com.sample.dcs.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdminController.
 */
@RequestMapping("/api/v1")
@Api(value = "admin Management System", description = "Operations pertaining to Admin cache evict  Management System")
public interface AdminController {

	/**
	 * Evict employee cache.
	 *
	 * @throws Exception the exception
	 */
	@DeleteMapping("/admin/evictCache}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Evict employee succesfully") })
	void evictEmployeeCache() throws Exception;
}
