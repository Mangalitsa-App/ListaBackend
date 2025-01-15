package com.mangalitsa.litsa.services;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmailSender {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(UUID randomToken, String email) throws MessagingException
    {
        String content = "Click the link below to reset your password:\n\nhttp://localhost:8080/reset-password?email=" + email + "&token=" + randomToken;
        String subject = "Reset Password";;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }
}
