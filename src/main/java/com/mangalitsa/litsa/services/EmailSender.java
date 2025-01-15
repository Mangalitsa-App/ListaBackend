package com.mangalitsa.litsa.services;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailSender {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail() throws MessagingException
    {
        String htmlContent = "Hi %s, <br /><br />Welcome to <b>MyCompany</b>. <br />Your UserID is: <b>%s</b> and Password is: <b>%s</b><br /><h5>This is system generated password. You can change it anytime after login.</h5><h5>Please do not share this credential with anybody else.</h5><br />With regards,<br />MyCompany";
        htmlContent = String.format(htmlContent, "Nesrin", "userid", "random pass");

        String subject = "Welcome %s (%s) on successful registration";
        subject = String.format(subject, "Nesrin", "userid");


        MimeMessage message = mailSender.createMimeMessage();
        message.setRecipients(MimeMessage.RecipientType.TO, "mathteacher120990@gmail.com");
        message.setSubject(subject);
        message.setContent(htmlContent, "text/html; charset=utf-8");
        mailSender.send(message);
    }
}
