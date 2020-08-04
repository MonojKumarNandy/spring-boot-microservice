package com.demo.employee.controller;

import java.util.List;

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

import com.demo.employee.entities.Employee;
import com.demo.employee.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	public static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		LOGGER.debug("get all employees Employee Service");
		System.out.println("emp");
		return employeeService.getAllEmployees();
	}

	@GetMapping("/getEmployee/{id}")
	public Employee getEmployeeById(@PathVariable long id) {
		LOGGER.debug("get employee by id Employee Service");
		return employeeService.getEmployeeById(id);
	}

	@PostMapping("/add")
	public void addEmployee(@RequestBody Employee employee) {
		LOGGER.debug("add employee Employee Service");
		employeeService.saveEmployee(employee);

	}

	@PutMapping("/edit")
	public void editEmployee(@RequestBody Employee employee) {
		LOGGER.debug("edit employee Employee Service");
		employeeService.saveEmployee(employee);

	}

	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable long id) {
		LOGGER.debug("delete employee Employee Service");
		employeeService.deleteEmployee(id);
	}
}
