package com.mangalitsa.litsa.services;

import com.mangalitsa.litsa.controllers.model.PasswordResetRequest;

public interface PasswordResetTokenService {
     void resetPassword(PasswordResetRequest request);
}
