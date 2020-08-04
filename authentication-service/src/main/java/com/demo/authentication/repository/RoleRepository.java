package com.demo.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.authentication.entitity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRoleId(long id);
}
