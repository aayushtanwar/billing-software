package com.project.billing_software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.billing_software.model.AuditLog;
import com.project.billing_software.repository.AuditLogRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuditLogService {
    @Autowired
    private AuditLogRepository auditLogRepository;

    public List<AuditLog> getAllLogs() {
        return auditLogRepository.findAll();
    }

    public Optional<AuditLog> getLogById(Long id) {
        return auditLogRepository.findById(id);
    }

    public AuditLog saveLog(AuditLog log) {
        return auditLogRepository.save(log);
    }

    public Optional<AuditLog> updateLog(Long id, AuditLog log) {
        if (!auditLogRepository.existsById(id)) {
            return Optional.empty();
        }
        log.setId(id); // Set the ID to update
        return Optional.of(auditLogRepository.save(log));
    }

    public boolean deleteLog(Long id) {
        if (auditLogRepository.existsById(id)) {
            auditLogRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
