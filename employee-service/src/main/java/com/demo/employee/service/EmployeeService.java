package com.demo.employee.service;

import java.util.List;

import com.demo.employee.entities.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(long id);

	public void saveEmployee(Employee employee);

	public void deleteEmployee(long id);
}
