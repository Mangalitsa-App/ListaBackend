package com.mangalitsa.litsa.controllers;

import com.mangalitsa.litsa.controllers.model.UserResponse;
import com.mangalitsa.litsa.services.auth.AuthenticationService;
import com.mangalitsa.litsa.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<UserResponse> getUser(@AuthenticationPrincipal UserDetails userDetails) {
            String email = userDetails.getUsername();// email for us
            UserResponse response = userService.getUserByEmail(email);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }


    // TODO: PATCH /{field}
    //       maybe also PUT?
}
