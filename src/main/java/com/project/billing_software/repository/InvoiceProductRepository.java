package com.project.billing_software.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.billing_software.model.Invoice;
import com.project.billing_software.model.InvoiceProduct;
import com.project.billing_software.model.Product;

@Repository
public interface InvoiceProductRepository extends JpaRepository<InvoiceProduct, Long> {
    List<InvoiceProduct> findByInvoice(Invoice invoice);
    List<InvoiceProduct> findByProduct(Product product);
}