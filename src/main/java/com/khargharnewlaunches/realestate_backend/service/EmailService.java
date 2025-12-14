package com.khargharnewlaunches.realestate_backend.service;

import com.khargharnewlaunches.realestate_backend.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AdminConfig adminConfig;


    public void sendLeadNotification(
            String projectName,
            String name,
            String phone,
            String email,
            String message
    ) {

        String subject = "New Lead Received - " + projectName;

        String body =
                "New lead details:\n\n" +
                        "Project: " + projectName + "\n" +
                        "Name: " + name + "\n" +
                        "Phone: " + phone + "\n" +
                        "Email: " + (email == null ? "N/A" : email) + "\n" +
                        "Message: " + (message == null ? "N/A" : message) + "\n\n" +
                        "Please contact them ASAP.";

        List<String> recipients = adminConfig.getAdminEmails();

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(recipients.toArray(new String[0]));  // multiple admins
        mail.setSubject(subject);
        mail.setText(body);

        mailSender.send(mail);
    }
}