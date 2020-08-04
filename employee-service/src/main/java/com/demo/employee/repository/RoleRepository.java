package com.demo.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.employee.entities.Role;



public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRoleId(long id);
}
