package com.mangalitsa.litsa.controllers;

import com.mangalitsa.litsa.controllers.model.ConfirmPasswordResetRequest;
import com.mangalitsa.litsa.controllers.model.PasswordResetRequest;
import com.mangalitsa.litsa.services.EmailSender;
import com.mangalitsa.litsa.services.PasswordResetTokenService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/password")
public class PasswordController {

    @Autowired
    PasswordResetTokenService passwordResetTokenService;
    @Autowired
    EmailSender emailSender;


    @PostMapping("/request-password-reset")
    public ResponseEntity<Void> requestPasswordReset(@RequestBody PasswordResetRequest request) {
        passwordResetTokenService.resetPassword(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Void> resetPassword(@RequestBody ConfirmPasswordResetRequest request){
        passwordResetTokenService.confirmResetPassword(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/sendemail")
    public String sendEmail() throws AddressException, MessagingException, IOException {
        emailSender.sendEmail();
        return "Email sent successfully";
    }
}
