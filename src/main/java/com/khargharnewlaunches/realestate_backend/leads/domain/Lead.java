package com.khargharnewlaunches.realestate_backend.leads.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Project info
    @Column(nullable = false)
    private String projectSlug;

    @Column(nullable = false)
    private String projectName;

    // Person info
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 20)
    private String phone;

    private String email;

    // Extra info
    private String message;
    private String bhkPreference;
    private String budgetRange;

    // Marketing tracking
    private String utmSource;
    private String utmMedium;
    private String utmCampaign;
    private String gclid;

    // Technical
    private String ipAddress;
    private String userAgent;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LeadStatus status = LeadStatus.NEW;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    public Lead() {
    }

    // ==== getters & setters ====

    public Long getId() {
        return id;
    }

    public String getProjectSlug() {
        return projectSlug;
    }

    public void setProjectSlug(String projectSlug) {
        this.projectSlug = projectSlug;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBhkPreference() {
        return bhkPreference;
    }

    public void setBhkPreference(String bhkPreference) {
        this.bhkPreference = bhkPreference;
    }

    public String getBudgetRange() {
        return budgetRange;
    }

    public void setBudgetRange(String budgetRange) {
        this.budgetRange = budgetRange;
    }

    public String getUtmSource() {
        return utmSource;
    }

    public void setUtmSource(String utmSource) {
        this.utmSource = utmSource;
    }

    public String getUtmMedium() {
        return utmMedium;
    }

    public void setUtmMedium(String utmMedium) {
        this.utmMedium = utmMedium;
    }

    public String getUtmCampaign() {
        return utmCampaign;
    }

    public void setUtmCampaign(String utmCampaign) {
        this.utmCampaign = utmCampaign;
    }

    public String getGclid() {
        return gclid;
    }

    public void setGclid(String gclid) {
        this.gclid = gclid;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public LeadStatus getStatus() {
        return status;
    }

    public void setStatus(LeadStatus status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}