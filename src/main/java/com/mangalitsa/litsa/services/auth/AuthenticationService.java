package com.mangalitsa.litsa.services.auth;

import com.mangalitsa.litsa.controllers.model.AuthRequest;
import com.mangalitsa.litsa.controllers.model.AuthResponse;
import com.mangalitsa.litsa.model.Password;
import com.mangalitsa.litsa.model.User;
import com.mangalitsa.litsa.repositories.PasswordRepository;
import com.mangalitsa.litsa.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    UserRepository userRepository;
    PasswordRepository passwordRepository;
    PasswordEncoder passwordEncoder;
    AuthenticationManager authenticationManager;
    JwtService jwtService;

    public AuthenticationService(
            UserRepository userRepository,
            PasswordRepository passwordRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordRepository = passwordRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService =jwtService;
    }

    public AuthResponse authenticate(AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.email(),
                        authRequest.password()
                )
        );

        User user = userRepository.findByEmail(authRequest.email())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Password password = passwordRepository.findByUser(user);
        CustomUserDetails userDetails = new CustomUserDetails(user, password);

        String jwtToken = jwtService.generateToken(userDetails);

        return new AuthResponse(jwtToken, jwtService.getExpirationTime());
    }
}