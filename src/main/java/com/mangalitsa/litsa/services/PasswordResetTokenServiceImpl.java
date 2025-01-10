package com.mangalitsa.litsa.services;

import com.mangalitsa.litsa.controllers.model.PasswordResetRequest;
import com.mangalitsa.litsa.model.PasswordResetToken;
import com.mangalitsa.litsa.model.User;
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

    @Override
    public void resetPassword(PasswordResetRequest request) {
        Optional<User> optionalUser = userRepository.findByEmail(request.email());
        if(optionalUser.isEmpty()){
            throw new RuntimeException();
        } else {
            User user = optionalUser.get();
            UUID randomToken = UUID.randomUUID();
            PasswordResetToken passwordResetToken = new PasswordResetToken();
            passwordResetToken.setResetToken(randomToken);
            passwordResetToken.setUser(user);
            passwordResetToken.setExpiresAt(LocalDateTime.now().plusMinutes(15));
            passwordResetTokenRepository.save(passwordResetToken);
            //Todo : sent email
        }

    }
}
