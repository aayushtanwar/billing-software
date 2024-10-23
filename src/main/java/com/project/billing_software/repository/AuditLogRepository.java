package com.project.billing_software.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.billing_software.model.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}