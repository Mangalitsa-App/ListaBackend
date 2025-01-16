package com.mangalitsa.litsa.services.auth;

import com.mangalitsa.litsa.model.Password;
import com.mangalitsa.litsa.model.User;
import com.mangalitsa.litsa.repositories.PasswordRepository;
import com.mangalitsa.litsa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordRepository passwordRepository;

    public UserDetails loadUserByUsername(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Password password = passwordRepository.findByUser(user);

        return new CustomUserDetails(user, password);
    }
}