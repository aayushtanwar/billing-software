package com.project.billing_software.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.billing_software.model.Invoice;
import com.project.billing_software.service.InvoiceService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    
    @Autowired
    private InvoiceService invoiceService;

    @Operation(summary = "Get all Invoices")
    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.findAllInvoices();
    }

    @Operation(summary = "Get Invoice by Id")
    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
        return invoiceService.findInvoiceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new Invoice")
    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return invoiceService.saveInvoice(invoice);
    }

    @Operation(summary = "Update an existing Invoice")
    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable Long id, @RequestBody Invoice invoiceDetails) {
        return invoiceService.findInvoiceById(id)
                .map(invoice -> {
                    invoice.setTotalAmount(invoiceDetails.getTotalAmount());
                    invoice.setCustomer(invoiceDetails.getCustomer());
                    // Update other fields as necessary
                    return ResponseEntity.ok(invoiceService.saveInvoice(invoice));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete an existing Invoice")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }
}