package com.project.billing_software.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.billing_software.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}