package com.mangalitsa.litsa.services;

import com.mangalitsa.litsa.controllers.model.ConfirmPasswordResetRequest;
import com.mangalitsa.litsa.controllers.model.PasswordResetRequest;
import jakarta.mail.MessagingException;

public interface PasswordResetTokenService {
     void resetPassword(PasswordResetRequest request) throws MessagingException;

     void confirmResetPassword(ConfirmPasswordResetRequest request);
}
