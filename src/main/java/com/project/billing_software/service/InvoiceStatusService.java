package com.project.billing_software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.billing_software.model.InvoiceStatus;
import com.project.billing_software.repository.InvoiceStatusRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {
    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;

    public List<InvoiceStatus> getAllStatuses() {
        return invoiceStatusRepository.findAll();
    }

    public Optional<InvoiceStatus> getStatusById(Long id) {
        return invoiceStatusRepository.findById(id);
    }

    public InvoiceStatus saveStatus(InvoiceStatus status) {
        return invoiceStatusRepository.save(status);
    }

    public Optional<InvoiceStatus> updateStatus(Long id, InvoiceStatus status) {
        if (!invoiceStatusRepository.existsById(id)) {
            return Optional.empty();
        }
        status.setId(id); // Set the ID to update
        return Optional.of(invoiceStatusRepository.save(status));
    }

    public boolean deleteStatus(Long id) {
        if (invoiceStatusRepository.existsById(id)) {
            invoiceStatusRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
