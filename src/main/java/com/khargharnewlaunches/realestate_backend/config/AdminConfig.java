package com.khargharnewlaunches.realestate_backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AdminConfig {

    @Value("${admin.emails}")
    private String adminEmailsRaw;

    public List<String> getAdminEmails() {
        return Arrays.stream(adminEmailsRaw.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }
}