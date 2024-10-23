package com.project.billing_software.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.billing_software.model.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
