package com.mangalitsa.litsa.services;

import com.mangalitsa.litsa.controllers.model.ConfirmPasswordResetRequest;
import com.mangalitsa.litsa.controllers.model.PasswordResetRequest;

public interface PasswordResetTokenService {
     void resetPassword(PasswordResetRequest request);

     void confirmResetPassword(ConfirmPasswordResetRequest request);
}
