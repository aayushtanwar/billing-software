package com.project.billing_software.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.billing_software.model.Customer;
import com.project.billing_software.model.Invoice;
import com.project.billing_software.model.User;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByCustomer(Customer customer);
    List<Invoice> findByUser(User user);
}
