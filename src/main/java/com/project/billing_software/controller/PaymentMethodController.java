package com.project.billing_software.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.billing_software.model.PaymentMethod;
import com.project.billing_software.service.PaymentMethodService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/payment-methods")
public class PaymentMethodController {
    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping
    public List<PaymentMethod> getAllMethods() {
        return paymentMethodService.getAllMethods();
    }

    @Operation(summary = "Get all Payment Methods")
    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethod> getMethodById(@PathVariable Long id) {
        return paymentMethodService.getMethodById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new Payment Method")
    @PostMapping
    public PaymentMethod createMethod(@RequestBody PaymentMethod method) {
        return paymentMethodService.saveMethod(method);
    }

    @Operation(summary = "Update an existing Payment Method")
    @PutMapping("/{id}")
    public ResponseEntity<PaymentMethod> updateMethod(@PathVariable Long id, @RequestBody PaymentMethod method) {
        return paymentMethodService.updateMethod(id, method)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Remove existing Payment Method")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMethod(@PathVariable Long id) {
        if (paymentMethodService.deleteMethod(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
