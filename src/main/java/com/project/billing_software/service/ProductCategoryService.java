package com.project.billing_software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.billing_software.model.ProductCategory;
import com.project.billing_software.repository.ProductCategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> getAllCategories() {
        return productCategoryRepository.findAll();
    }

    public Optional<ProductCategory> getCategoryById(Long id) {
        return productCategoryRepository.findById(id);
    }

    public ProductCategory saveCategory(ProductCategory category) {
        return productCategoryRepository.save(category);
    }

    public Optional<ProductCategory> updateCategory(Long id, ProductCategory category) {
        if (!productCategoryRepository.existsById(id)) {
            return Optional.empty();
        }
        category.setId(id); // Set the ID to update
        return Optional.of(productCategoryRepository.save(category));
    }

    public boolean deleteCategory(Long id) {
        if (productCategoryRepository.existsById(id)) {
            productCategoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}