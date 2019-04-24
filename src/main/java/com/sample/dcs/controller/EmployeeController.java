package com.sample.dcs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.dcs.model.EmployeeDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * The Interface EmployeeController.
 */
@RequestMapping("/api/v1")
@Api(value = "Employee Management System", description = "Operations pertaining to Employee cache Management System")
public interface EmployeeController {

	/**
	 * Gets the all employees.
	 *
	 * @param page the page
	 * @param limit the limit
	 * @return the all employees
	 * @throws Exception the exception
	 */
	@ApiOperation(value = "View a list of available employees", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/employees")
	Page<EmployeeDto> getAllEmployees(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit) throws Exception;

	/**
	 * Gets the employee by id.
	 *
	 * @param employeeId the employee id
	 * @return the employee by id
	 * @throws Exception the exception
	 */
	@GetMapping("/employee/{id}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list", response = EmployeeDto.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(value = "id") @ApiParam(value = "Valid employee id") final Long employeeId) throws Exception;

	/**
	 * Update employee.
	 *
	 * @param employeeId the employee id
	 * @param employeeDetails the employee details
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@PutMapping("/employee/{id}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Updated Employee", response = EmployeeDto.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") @ApiParam(value = "Valid employee id") Long employeeId, @Valid @RequestBody EmployeeDto employeeDetails)
			throws Exception;
}
