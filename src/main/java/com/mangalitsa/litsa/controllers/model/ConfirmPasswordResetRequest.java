package com.mangalitsa.litsa.controllers.model;

import java.util.UUID;

public record ConfirmPasswordResetRequest (
        String email,
        UUID token,
        String password

){
}
