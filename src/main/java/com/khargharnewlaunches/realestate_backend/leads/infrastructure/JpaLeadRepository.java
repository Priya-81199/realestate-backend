package com.khargharnewlaunches.realestate_backend.leads.infrastructure;

import com.khargharnewlaunches.realestate_backend.leads.domain.Lead;
import com.khargharnewlaunches.realestate_backend.leads.domain.LeadRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaLeadRepository
        extends JpaRepository<Lead, Long>, LeadRepository {

    @Override
    List<Lead> findByProjectSlug(String projectSlug);
}