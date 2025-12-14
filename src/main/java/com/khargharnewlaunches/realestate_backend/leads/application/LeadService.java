package com.khargharnewlaunches.realestate_backend.leads.application;

import com.khargharnewlaunches.realestate_backend.leads.domain.Lead;
import com.khargharnewlaunches.realestate_backend.leads.domain.LeadRepository;
import com.khargharnewlaunches.realestate_backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {

    @Autowired
    private EmailService emailService;

    private final LeadRepository leadRepository;

    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public Lead createLead(Lead lead) {
        emailService.sendLeadNotification(
                lead.getProjectName(),
                lead.getName(),
                lead.getPhone(),
                lead.getEmail(),
                lead.getMessage()
        );
        return leadRepository.save(lead);
    }

    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }
}