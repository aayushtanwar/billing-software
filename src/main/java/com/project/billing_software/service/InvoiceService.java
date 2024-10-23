package com.project.billing_software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.billing_software.model.Customer;
import com.project.billing_software.model.Invoice;
import com.project.billing_software.model.User;
import com.project.billing_software.repository.InvoiceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    
    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> findAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> findInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    public List<Invoice> findByCustomer(Customer customer) {
        return invoiceRepository.findByCustomer(customer);
    }

    public List<Invoice> findByUser(User user) {
        return invoiceRepository.findByUser(user);
    }
}
