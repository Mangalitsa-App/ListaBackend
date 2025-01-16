package com.mangalitsa.litsa.controllers;

import com.mangalitsa.litsa.controllers.model.AuthResponse;
import com.mangalitsa.litsa.controllers.model.AuthRequest;
import com.mangalitsa.litsa.controllers.model.NewUserRequest;
import com.mangalitsa.litsa.controllers.model.UserResponse;
import com.mangalitsa.litsa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public UserResponse getUser() {
        return null;// TODO
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest body) {
        return null; // TODO
    }

    @PostMapping
    public ResponseEntity<Void> signUp(@RequestBody NewUserRequest request) throws NoSuchAlgorithmException, InvalidKeySpecException {
        userService.signUp(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // TODO: PATCH /{field}
    //       maybe also PUT?
}
