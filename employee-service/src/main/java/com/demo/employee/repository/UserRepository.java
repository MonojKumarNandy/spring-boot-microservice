package com.demo.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.employee.entities.User;



public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
