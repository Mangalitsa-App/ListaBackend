package com.mangalitsa.litsa.services;

import com.mangalitsa.litsa.controllers.model.NewUserRequest;
import com.mangalitsa.litsa.controllers.model.UserResponse;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface UserService {

    UserResponse getUserByEmail(String email);

    void signUp(NewUserRequest request) throws NoSuchAlgorithmException, InvalidKeySpecException;
}

