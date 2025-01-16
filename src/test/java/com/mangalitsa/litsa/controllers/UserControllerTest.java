package com.mangalitsa.litsa.controllers;

import com.mangalitsa.litsa.controllers.model.AuthResponse;
import com.mangalitsa.litsa.controllers.model.AuthRequest;
import com.mangalitsa.litsa.controllers.model.NewUserRequest;
import com.mangalitsa.litsa.controllers.model.UserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    private UserController userController;

    @BeforeEach
    void setUp() {
        userController = new UserController();
    }

    @Test
    void getUser() {
        UserResponse expected = null;
        var result = userController.getUser();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void login() {
        var requestBody = new AuthRequest("some@example.com", "securePassword");
        AuthResponse expected = null;
        var result = userController.login(requestBody);
        assertThat(result).isEqualTo(expected);
    }

//    @Test
//    void addUser() {
//        AuthResponse expected = null;
//        var requestBody = new NewUserRequest("some@example.com", "securePassword", "Bob");
//        var result = userController.addUser(requestBody);
//        assertThat(result).isEqualTo(expected);
//    }
}