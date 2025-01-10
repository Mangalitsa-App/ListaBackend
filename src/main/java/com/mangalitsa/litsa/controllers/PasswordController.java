package com.mangalitsa.litsa.controllers;

import com.mangalitsa.litsa.controllers.model.PasswordResetRequest;
import com.mangalitsa.litsa.controllers.model.UserResponse;
import com.mangalitsa.litsa.services.PasswordResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/password")
public class PasswordController {

    @Autowired
    PasswordResetTokenService passwordResetTokenService;


    @PostMapping("/request-password-reset")
    public void requestPasswordReset(@RequestBody PasswordResetRequest request) {
        passwordResetTokenService.resetPassword(request);
    }
}
