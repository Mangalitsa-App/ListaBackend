package com.mangalitsa.litsa.services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface PasswordService {
    String hashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException;
}
