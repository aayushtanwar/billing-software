package com.project.billing_software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.billing_software.model.Discount;
import com.project.billing_software.repository.DiscountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountService {
    @Autowired
    private DiscountRepository discountRepository;

    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    public Optional<Discount> getDiscountById(Long id) {
        return discountRepository.findById(id);
    }

    public Discount saveDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    public Optional<Discount> updateDiscount(Long id, Discount discount) {
        if (!discountRepository.existsById(id)) {
            return Optional.empty();
        }
        discount.setId(id); // Set the ID to update
        return Optional.of(discountRepository.save(discount));
    }

    public boolean deleteDiscount(Long id) {
        if (discountRepository.existsById(id)) {
            discountRepository.deleteById(id);
            return true;
        }
        return false;
    }
}