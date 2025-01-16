package com.mangalitsa.litsa.services;

import com.mangalitsa.litsa.controllers.model.NewUserRequest;
import com.mangalitsa.litsa.model.Password;
import com.mangalitsa.litsa.model.User;
import com.mangalitsa.litsa.repositories.PasswordRepository;
import com.mangalitsa.litsa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordRepository passwordRepository;

    @Autowired
    PasswordService passwordService;

    @Override
    public void signUp(NewUserRequest request) throws NoSuchAlgorithmException, InvalidKeySpecException {

        User user = new User();
        user.setEmail(request.email());
        user.setCreatedAt(LocalDateTime.now());
        user.setDisplayName(request.displayName());
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);

        String hashedPassword = passwordService.hashPassword(request.password());

        Password password = new Password();
        password.setUser(user);
        password.setCreatedAt(LocalDateTime.now());
        password.setPasswordHash(hashedPassword);
        passwordRepository.save(password);
    }
}
