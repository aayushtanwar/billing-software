package com.project.billing_software.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.billing_software.model.InvoiceProduct;
import com.project.billing_software.service.InvoiceProductService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/invoice-products")
public class InvoiceProductController {
    
    @Autowired
    private InvoiceProductService invoiceProductService;

    @Operation(summary = "Get all InvoiceProducts")
    @GetMapping
    public List<InvoiceProduct> getAllInvoiceProducts() {
        return invoiceProductService.findAllInvoiceProducts();
    }

    @Operation(summary = "Get InvoiceProduct by Id")
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceProduct> getInvoiceProductById(@PathVariable Long id) {
        return invoiceProductService.findInvoiceProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new InvoiceProduct")
    @PostMapping
    public InvoiceProduct createInvoiceProduct(@RequestBody InvoiceProduct invoiceProduct) {
        return invoiceProductService.saveInvoiceProduct(invoiceProduct);
    }

    @Operation(summary = "Update an existing InvoiceProduct")
    @PutMapping("/{id}")
    public ResponseEntity<InvoiceProduct> updateInvoiceProduct(@PathVariable Long id, @RequestBody InvoiceProduct invoiceProductDetails) {
        return invoiceProductService.findInvoiceProductById(id)
                .map(invoiceProduct -> {
                    invoiceProduct.setInvoice(invoiceProductDetails.getInvoice());
                    invoiceProduct.setProduct(invoiceProductDetails.getProduct());
                    invoiceProduct.setQuantity(invoiceProductDetails.getQuantity());
                    // Update other fields as necessary
                    return ResponseEntity.ok(invoiceProductService.saveInvoiceProduct(invoiceProduct));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete an existing InvoiceProduct")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoiceProduct(@PathVariable Long id) {
        invoiceProductService.deleteInvoiceProduct(id);
        return ResponseEntity.noContent().build();
    }
}
