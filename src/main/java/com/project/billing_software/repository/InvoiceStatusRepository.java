package com.project.billing_software.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.billing_software.model.InvoiceStatus;

public interface InvoiceStatusRepository extends JpaRepository<InvoiceStatus, Long> {
}
