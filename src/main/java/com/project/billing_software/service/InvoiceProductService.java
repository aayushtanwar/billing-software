package com.project.billing_software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.billing_software.model.Invoice;
import com.project.billing_software.model.InvoiceProduct;
import com.project.billing_software.model.Product;
import com.project.billing_software.repository.InvoiceProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceProductService {
    
    @Autowired
    private InvoiceProductRepository invoiceProductRepository;

    public List<InvoiceProduct> findAllInvoiceProducts() {
        return invoiceProductRepository.findAll();
    }

    public Optional<InvoiceProduct> findInvoiceProductById(Long id) {
        return invoiceProductRepository.findById(id);
    }

    public InvoiceProduct saveInvoiceProduct(InvoiceProduct invoiceProduct) {
        return invoiceProductRepository.save(invoiceProduct);
    }

    public void deleteInvoiceProduct(Long id) {
        invoiceProductRepository.deleteById(id);
    }

    public List<InvoiceProduct> findByInvoice(Invoice invoice) {
        return invoiceProductRepository.findByInvoice(invoice);
    }

    public List<InvoiceProduct> findByProduct(Product product) {
        return invoiceProductRepository.findByProduct(product);
    }
}
