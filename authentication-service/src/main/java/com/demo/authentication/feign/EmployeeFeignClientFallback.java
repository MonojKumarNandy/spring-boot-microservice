package com.demo.authentication.feign;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.demo.authentication.entitity.Employee;

@Component
public class EmployeeFeignClientFallback implements EmployeeFeignClient {

	public static Logger LOGGER = LoggerFactory.getLogger(EmployeeFeignClientFallback.class);

	@Override
	public List<Employee> getAllEmployees(String header) {
		LOGGER.debug("fallback getAllEmployees");
		return null;
	}

	@Override
	public Employee getEmployeeById(String header, long id) {
		LOGGER.debug("fallback getEmployeeById");
		return null;
	}

	@Override
	public void addEmployee(String header, Employee employee) {
		LOGGER.debug("fallback addEmployee");

	}

	@Override
	public void editEmployee(String header, Employee employee) {
		LOGGER.debug("fallback editEmployee");

	}

	@Override
	public void deleteEmployee(String header, long id) {
		LOGGER.debug("fallback getAllEmployees");

	}

//"Requested service isn't available. Please try after sometime.";

}
