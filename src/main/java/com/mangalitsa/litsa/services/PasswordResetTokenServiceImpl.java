package com.mangalitsa.litsa.services;

import com.mailgun.api.v3.MailgunMessagesApi;
import com.mailgun.client.MailgunClient;
import com.mailgun.model.message.Message;
import com.mailgun.model.message.MessageResponse;
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
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {

    private static final String BASE_URL = "https://api.mailgun.net/";
    private static final String EMAIL_FROM = "mailgun@sandbox3d27d0c4d7254d70abd9c7b653062e3d.mailgun.org";
    private final String API_KEY = "3db0c10f74a745fe1c74b193e5d6632b-7113c52e-421ea02a";

    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordRepository passwordRepository;

    @Override
    public void resetPassword(PasswordResetRequest request) {
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

            MailgunMessagesApi api = MailgunClient.config(BASE_URL, API_KEY)
                    .createApi(MailgunMessagesApi.class);

            Message message = Message.builder()
                    .from(EMAIL_FROM)
                    .to(user.getEmail())
                    .subject("Password Reset")
                    .text("Click the link below to reset your password:\n"+ "\nhttp://litsaDB.com?email=" + user.getEmail() + "&token=" + randomToken)
                    .build();

            MessageResponse messageResponse = api.sendMessage("sandbox3d27d0c4d7254d70abd9c7b653062e3d.mailgun.org", message);
            System.out.println(messageResponse);
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
