package com.project.billing_software.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.billing_software.model.Tax;
import com.project.billing_software.repository.TaxRepository;

@Service
public class TaxService {
    @Autowired
    private TaxRepository taxRepository;

    public List<Tax> getAllTaxes() {
        return taxRepository.findAll();
    }

    public Tax getTaxById(Long id) {
        return taxRepository.findById(id).orElse(null);
    }

    public Tax createTax(Tax tax) {
        return taxRepository.save(tax);
    }

    public void deleteTax(Long id) {
        taxRepository.deleteById(id);
    }
}