package com.project.billing_software.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.billing_software.model.InvoiceStatus;
import com.project.billing_software.service.InvoiceStatusService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/invoice-statuses")
public class InvoiceStatusController {
    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @Operation(summary = "Get all Invoice Statuses")
    @GetMapping
    public List<InvoiceStatus> getAllStatuses() {
        return invoiceStatusService.getAllStatuses();
    }

    @Operation(summary = "Get Status by Id")
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceStatus> getStatusById(@PathVariable Long id) {
        return invoiceStatusService.getStatusById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new Invoice Status")
    @PostMapping
    public InvoiceStatus createStatus(@RequestBody InvoiceStatus status) {
        return invoiceStatusService.saveStatus(status);
    }

    @Operation(summary = "Update existing Invoice Status")
    @PutMapping("/{id}")
    public ResponseEntity<InvoiceStatus> updateStatus(@PathVariable Long id, @RequestBody InvoiceStatus status) {
        return invoiceStatusService.updateStatus(id, status)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Remove existing Invoice Status")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
        if (invoiceStatusService.deleteStatus(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
