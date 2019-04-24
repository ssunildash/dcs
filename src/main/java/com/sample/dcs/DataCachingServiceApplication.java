package com.sample.dcs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.sample.dcs.entity.Employee;
import com.sample.dcs.repository.EmployeeRepository;

/**
 * The Class DataCachingServiceApplication.
 * 
 * @author sdash
 *
 */
@SpringBootApplication
@EnableCaching
@EnableRabbit
public class DataCachingServiceApplication implements CommandLineRunner {

	/** The  log. */
	private Logger _LOG = LoggerFactory.getLogger("DataCachingServiceApplication");

	/** The employee repository. */
	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(DataCachingServiceApplication.class, args);
	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	public void run(String... strings) {
		_LOG.info("inerst into DB");
		final List<Employee> employeeList = new ArrayList<>();

		LongStream.range(1, 50).forEach(i -> {
			employeeList.add(
					Employee.builder().id(i).firstName("sunil" + i).lastName("dash" + i).emailId("sunil.dash" + i + "@gmail.com").build());
		});

		employeeRepository.saveAll(employeeList);
		_LOG.info("Person created in DB : count: " + employeeRepository.count());
	}
}
