package com.project.billing_software.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.billing_software.model.AuditLog;
import com.project.billing_software.service.AuditLogService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {
    @Autowired
    private AuditLogService auditLogService;

    @Operation(summary = "Get a list of all logs")
    @GetMapping
    public List<AuditLog> getAllLogs() {
        return auditLogService.getAllLogs();
    }

    @Operation(summary = "Get logs by id")
    @GetMapping("/{id}")
    public ResponseEntity<AuditLog> getLogById(@PathVariable Long id) {
        return auditLogService.getLogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Creat audit log")
    @PostMapping
    public AuditLog createLog(@RequestBody AuditLog log) {
        return auditLogService.saveLog(log);
    }

    @Operation(summary = "Update existing log")
    @PutMapping("/{id}")
    public ResponseEntity<AuditLog> updateLog(@PathVariable Long id, @RequestBody AuditLog log) {
        return auditLogService.updateLog(id, log)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete log by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id) {
        if (auditLogService.deleteLog(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
