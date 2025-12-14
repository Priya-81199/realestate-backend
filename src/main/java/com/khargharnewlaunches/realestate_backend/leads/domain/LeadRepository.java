package com.khargharnewlaunches.realestate_backend.leads.domain;

import java.util.List;
import java.util.Optional;

public interface LeadRepository {
    Lead save(Lead lead);

    Optional<Lead> findById(Long id);

    List<Lead> findByProjectSlug(String projectSlug);

    List<Lead> findAll();
}