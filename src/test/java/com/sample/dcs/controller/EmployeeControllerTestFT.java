package com.sample.dcs.controller;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.dcs.DataCachingServiceApplication;
import com.sample.dcs.model.EmployeeDto;

import io.restassured.http.ContentType;

/**
 * The Class EmployeeControllerTestFT.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DataCachingServiceApplication.class })
public class EmployeeControllerTestFT {

	/**
	 * Test get all employees.
	 */
	@Test
	public void test_getAllEmployees() {
		given()
				.contentType(ContentType.JSON)//
				// .pathParam("page", "0")//
				.when()//
				.get("/api/v1/employees")//
				.then()//
				.log()//
				.body()//
				.statusCode(200)//
				.body("number", equalTo(0))//
				.body("content.size()", equalTo(10));

	}

	/**
	 * Test get all employees page 2.
	 */
	@Test
	public void test_getAllEmployeesPage2() {
		given()
				.contentType(ContentType.JSON)//
				.queryParam("page", "2")//
				.when()//
				.get("/api/v1/employees")//
				.then()//
				.log()//
				.body()//
				.statusCode(200)//
				.body("number", equalTo(2))//
				.body("content.size()", equalTo(10));

	}

	/**
	 * Test get all employees page notfound.
	 */
	@Test
	public void test_getAllEmployeesPage_notfound() {
		given()
				.contentType(ContentType.JSON)//
				.queryParam("page", "6")//
				.when()//
				.get("/api/v1/employees")//
				.then()//
				.log()//
				.body()//
				.statusCode(404);
	}
	
	/**
	 * Test get employee by id.
	 */
	@Test
	public void test_getEmployeeById() {
		given()
				.contentType(ContentType.JSON)//
				.queryParam("id", "2")//
				.when()//
				.get("/api/v1/employee")//
				.then()//
				.log()//
				.body()//
				.statusCode(200);
	}
	
	/**
	 * Test update employee detail.
	 */
	@Test
	public void test_updateEmployeeDetail() {
		given()
				.contentType(ContentType.JSON)//
				.queryParam("id", "2")//
				.body(new EmployeeDto(2L, "sunil", "changed", "sunil.changed@gmail.com"))//
				.when()//
				.put("/api/v1/employee")//
				.then()//
				.log()//
				.body()//
				.statusCode(200)//
				.body("id", equalTo(2))//
				.body("firstName", equalTo("sunil"))//
				.body("lastName", equalTo("changed"))//
				.body("emailId", equalTo("sunil.changed@gmail.com"));

	}
}
