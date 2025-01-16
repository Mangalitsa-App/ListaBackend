package com.mangalitsa.litsa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
