package com.khargharnewlaunches.realestate_backend.leads.web;

import com.khargharnewlaunches.realestate_backend.leads.application.LeadService;
import com.khargharnewlaunches.realestate_backend.leads.domain.Lead;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
@CrossOrigin(origins = "*")
public class LeadController {

    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @PostMapping
    public ResponseEntity<Lead> createLead(@RequestBody Lead lead,
                                           HttpServletRequest httpRequest) {
        String ip = extractClientIP(httpRequest);
        lead.setIpAddress(ip);
        Lead saved = leadService.createLead(lead);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Lead> getAllLeads() {
        return leadService.getAllLeads();
    }

    private String extractClientIP(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}