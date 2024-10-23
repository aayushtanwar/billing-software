package com.project.billing_software.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.billing_software.model.SupportTicket;
import com.project.billing_software.service.SupportTicketService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/support-tickets")
public class SupportTicketController {
    @Autowired
    private SupportTicketService supportTicketService;

    @Operation(summary = "Get all Support Tickets")
    @GetMapping
    public List<SupportTicket> getAllSupportTickets() {
        return supportTicketService.getAllSupportTickets();
    }

    @Operation(summary = "Get Support Ticket by Id")
    @GetMapping("/{id}")
    public SupportTicket getSupportTicketById(@PathVariable Long id) {
        return supportTicketService.getSupportTicketById(id);
    }

    @Operation(summary = "Create a new Support Ticket")
    @PostMapping
    public SupportTicket createSupportTicket(@RequestBody SupportTicket supportTicket) {
        return supportTicketService.createSupportTicket(supportTicket);
    }

    @Operation(summary = "Delete an existing Support Ticket")
    @DeleteMapping("/{id}")
    public void deleteSupportTicket(@PathVariable Long id) {
        supportTicketService.deleteSupportTicket(id);
    }
}
