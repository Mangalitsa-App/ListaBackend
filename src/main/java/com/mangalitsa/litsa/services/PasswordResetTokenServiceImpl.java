package com.mangalitsa.litsa.services;

import com.mangalitsa.litsa.controllers.model.ConfirmPasswordResetRequest;
import com.mangalitsa.litsa.controllers.model.PasswordResetRequest;
import com.mangalitsa.litsa.model.Password;
import com.mangalitsa.litsa.model.PasswordResetToken;
import com.mangalitsa.litsa.model.User;
import com.mangalitsa.litsa.repositories.PasswordRepository;
import com.mangalitsa.litsa.repositories.PasswordResetTokenRepository;
import com.mangalitsa.litsa.repositories.UserRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {

    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordRepository passwordRepository;

    @Autowired
    EmailSender emailSender;


    @Override
    public void resetPassword(PasswordResetRequest request) throws MessagingException {
        Optional<User> optionalUser = userRepository.findByEmail(request.email());

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User could not find!");
        } else {
            User user = optionalUser.get();
            UUID randomToken = UUID.randomUUID();
            PasswordResetToken passwordResetToken = new PasswordResetToken();
            passwordResetToken.setResetToken(randomToken);
            passwordResetToken.setUser(user);
            passwordResetToken.setExpiresAt(LocalDateTime.now().plusMinutes(15));
            passwordResetTokenRepository.save(passwordResetToken);

            emailSender.sendEmail(randomToken, user.getEmail());
        }
    }

    @Override
    public void confirmResetPassword(ConfirmPasswordResetRequest request) {
        User user = userRepository.findByEmail(request.email()).orElseThrow();

        Optional<PasswordResetToken> optionalToken = passwordResetTokenRepository.findByUser(user);

        if (optionalToken.isEmpty()) {
            throw new RuntimeException("Token could not find!");
        } else {
            PasswordResetToken passwordResetToken = optionalToken.get();
            if (passwordResetToken.getResetToken().equals(request.token())) {
                Password userPassword = passwordRepository.findByUser(user);
                userPassword.setPasswordHash(request.password()); //Todo : use passwordHash
                passwordRepository.save(userPassword);
            }
        }
    }
}
