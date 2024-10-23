package com.project.billing_software.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.billing_software.model.UserRole;
import com.project.billing_software.service.UserRoleService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @Operation(summary = "Get all User Roles")
    @GetMapping
    public List<UserRole> getAllRoles() {
        return userRoleService.getAllRoles();
    }

    @Operation(summary = "Get User Role by Id")
    @GetMapping("/{id}")
    public ResponseEntity<UserRole> getRoleById(@PathVariable Long id) {
        return userRoleService.getRoleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new User Role")
    @PostMapping
    public UserRole createRole(@RequestBody UserRole role) {
        return userRoleService.saveRole(role);
    }

    @Operation(summary = "Update an existing User Role")
    @PutMapping("/{id}")
    public ResponseEntity<UserRole> updateRole(@PathVariable Long id, @RequestBody UserRole role) {
        return userRoleService.updateRole(id, role)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete an existing User Role")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        if (userRoleService.deleteRole(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
