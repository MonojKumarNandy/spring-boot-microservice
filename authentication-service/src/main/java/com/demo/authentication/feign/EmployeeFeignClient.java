package com.demo.authentication.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.demo.authentication.entitity.Employee;

@FeignClient(value = "${feign.name}", url = "${feign.url}", fallback = EmployeeFeignClientFallback.class)
public interface EmployeeFeignClient {

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(@RequestHeader("Authorization") String header);

	@GetMapping("/getEmployee/{id}")
	public Employee getEmployeeById(@RequestHeader("Authorization") String header, @PathVariable long id);

	@PostMapping("/add")
	public void addEmployee(@RequestHeader("Authorization") String header, @RequestBody Employee employee);

	@PutMapping("/edit")
	public void editEmployee(@RequestHeader("Authorization") String header, @RequestBody Employee employee);

	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@RequestHeader("Authorization") String header, @PathVariable long id);
}
