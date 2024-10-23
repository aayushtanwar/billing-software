package com.project.billing_software.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.billing_software.model.Tax;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Long> {
}
