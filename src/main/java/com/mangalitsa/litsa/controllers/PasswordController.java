package com.mangalitsa.litsa.controllers;

import com.mangalitsa.litsa.controllers.model.PasswordResetRequest;
import com.mangalitsa.litsa.controllers.model.UserResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/password")
public class PasswordController {

    @PostMapping("/request-password-reset")
    public void requestPasswordReset(@RequestBody PasswordResetRequest request) {
        System.out.println("sdf");
    }
}
