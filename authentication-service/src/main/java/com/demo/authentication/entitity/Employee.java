package com.demo.authentication.entitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "employee")
public class Employee {

	private static final Logger LOGGER = LoggerFactory.getLogger(Employee.class);

	@Id
	@Column(name = "emp_id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "emp_firstName")
	private String firstName;

	@Column(name = "emp_middleName")
	private String middleName;

	@Column(name = "emp_lastName")
	private String lastName;

	@Column(name = "emp_gender")
	private String gender;

	@Column(name = "emp_email")
	private String email;

	public Employee() {
		super();
		LOGGER.debug("Inside User default Constructor");
	}

	public Employee(long id, String firstName, String middleName, String lastName, String gender, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		LOGGER.debug("Inside User default Constructor");
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
