package com.project.billing_software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.billing_software.model.PaymentMethod;
import com.project.billing_software.repository.PaymentMethodRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    public List<PaymentMethod> getAllMethods() {
        return paymentMethodRepository.findAll();
    }

    public Optional<PaymentMethod> getMethodById(Long id) {
        return paymentMethodRepository.findById(id);
    }

    public PaymentMethod saveMethod(PaymentMethod method) {
        return paymentMethodRepository.save(method);
    }

    public Optional<PaymentMethod> updateMethod(Long id, PaymentMethod method) {
        if (!paymentMethodRepository.existsById(id)) {
            return Optional.empty();
        }
        method.setId(id); // Set the ID to update
        return Optional.of(paymentMethodRepository.save(method));
    }

    public boolean deleteMethod(Long id) {
        if (paymentMethodRepository.existsById(id)) {
            paymentMethodRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
