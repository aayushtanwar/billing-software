package com.project.billing_software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.billing_software.model.UserRole;
import com.project.billing_software.repository.UserRoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserRole> getAllRoles() {
        return userRoleRepository.findAll();
    }

    public Optional<UserRole> getRoleById(Long id) {
        return userRoleRepository.findById(id);
    }

    public UserRole saveRole(UserRole role) {
        return userRoleRepository.save(role);
    }

    public Optional<UserRole> updateRole(Long id, UserRole role) {
        if (!userRoleRepository.existsById(id)) {
            return Optional.empty();
        }
        role.setId(id); // Set the ID to update
        return Optional.of(userRoleRepository.save(role));
    }

    public boolean deleteRole(Long id) {
        if (userRoleRepository.existsById(id)) {
            userRoleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}