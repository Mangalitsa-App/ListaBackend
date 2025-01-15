package com.mangalitsa.litsa.services;

import com.mangalitsa.litsa.controllers.model.NewUserRequest;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface UserService {
    void signUp(NewUserRequest request) throws NoSuchAlgorithmException, InvalidKeySpecException;
}

