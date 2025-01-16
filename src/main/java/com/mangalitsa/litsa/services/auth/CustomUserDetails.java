package com.mangalitsa.litsa.services.auth;

import com.mangalitsa.litsa.model.Password;
import com.mangalitsa.litsa.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

class CustomUserDetails implements UserDetails {
        User user;
        Password password;

        public CustomUserDetails(User user, Password password) {
            this.user = user;
            this.password = password;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return List.of();
        }

        @Override
        public String getPassword() {
            return password.getPasswordHash();
        }

        @Override
        public String getUsername() {
            return user.getEmail();
        }
    }