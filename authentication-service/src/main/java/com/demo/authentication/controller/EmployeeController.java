package com.demo.authentication.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.authentication.entitity.Employee;
import com.demo.authentication.feign.EmployeeFeignClient;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	public static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeFeignClient employeeFeignClient;

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(HttpServletRequest request) {
		LOGGER.debug("get all employees");
		return employeeFeignClient.getAllEmployees(request.getHeader("Authorization"));
	}

	@GetMapping("/getEmployee/{id}")
	public Employee getEmployeeById(HttpServletRequest request, @PathVariable long id) {
		LOGGER.debug("get employee by id");
		return employeeFeignClient.getEmployeeById(request.getHeader("Authorization"), id);
	}

	@PostMapping("/add")
	public void addEmployee(HttpServletRequest request, @RequestBody Employee employee) {
		LOGGER.debug("add employee");
		employeeFeignClient.addEmployee(request.getHeader("Authorization"), employee);

	}

	@PutMapping("/edit")
	public void editEmployee(HttpServletRequest request, @RequestBody Employee employee) {
		LOGGER.debug("edit employee");
		employeeFeignClient.editEmployee(request.getHeader("Authorization"), employee);

	}

	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(HttpServletRequest request, @PathVariable long id) {
		LOGGER.debug("delete employee");
		employeeFeignClient.deleteEmployee(request.getHeader("Authorization"), id);
	}

}
