package com.mangalitsa.litsa.services;

import com.mangalitsa.litsa.controllers.model.ConfirmPasswordResetRequest;
import com.mangalitsa.litsa.controllers.model.PasswordResetRequest;
import com.mangalitsa.litsa.model.Password;
import com.mangalitsa.litsa.model.PasswordResetToken;
import com.mangalitsa.litsa.model.User;
import com.mangalitsa.litsa.repositories.PasswordRepository;
import com.mangalitsa.litsa.repositories.PasswordResetTokenRepository;
import com.mangalitsa.litsa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService{

    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordRepository passwordRepository;

    @Override
    public void resetPassword(PasswordResetRequest request) {
        Optional<User> optionalUser = userRepository.findByEmail(request.email());
        if(optionalUser.isEmpty()){
            throw new RuntimeException("User could not find!");
        } else {
            User user = optionalUser.get();
            UUID randomToken = UUID.randomUUID();
            PasswordResetToken passwordResetToken = new PasswordResetToken();
            passwordResetToken.setResetToken(randomToken);
            passwordResetToken.setUser(user);
            passwordResetToken.setExpiresAt(LocalDateTime.now().plusMinutes(15));
            passwordResetTokenRepository.save(passwordResetToken);
            //Todo : send email
        }

    }

    @Override
    public void confirmResetPassword(ConfirmPasswordResetRequest request) {
        Optional<PasswordResetToken> optionalToken = passwordResetTokenRepository.findByEmail(request.email());
        if(optionalToken.isEmpty()) {
            throw new RuntimeException("Token could not find!");
        } else {
            Optional<User> optionalUser = userRepository.findByEmail(request.email());
            PasswordResetToken passwordResetToken = optionalToken.get();
            if(passwordResetToken.getResetToken().equals(request.token())){
                Password userPassword = passwordRepository.findByUser(optionalUser.get());
                userPassword.setPasswordHash(request.password()); //Todo : use passwordHash
                passwordRepository.save(userPassword);
            }
        }
    }
}
