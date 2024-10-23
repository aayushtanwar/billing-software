package com.project.billing_software.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.billing_software.model.Tax;
import com.project.billing_software.service.TaxService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/taxes")
public class TaxController {
    @Autowired
    private TaxService taxService;

    @Operation(summary = "Get all Tax")
    @GetMapping
    public List<Tax> getAllTaxes() {
        return taxService.getAllTaxes();
    }

    @Operation(summary = "Get Tax by Id")
    @GetMapping("/{id}")
    public Tax getTaxById(@PathVariable Long id) {
        return taxService.getTaxById(id);
    }

    @Operation(summary = "Create a new Tax")
    @PostMapping
    public Tax createTax(@RequestBody Tax tax) {
        return taxService.createTax(tax);
    }

    @Operation(summary = "Delete an existing Tax")
    @DeleteMapping("/{id}")
    public void deleteTax(@PathVariable Long id) {
        taxService.deleteTax(id);
    }
}