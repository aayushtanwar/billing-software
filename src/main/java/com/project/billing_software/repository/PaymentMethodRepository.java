package com.project.billing_software.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.billing_software.model.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
