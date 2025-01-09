package com.mangalitsa.litsa.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "password_reset_token")
public class PasswordResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reset_token", nullable = false, unique = true)
    private UUID resetToken;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @Column(nullable = false)
    private Boolean used = false;


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public UUID getResetToken() {return resetToken;}
    public void setResetToken(UUID resetToken) {this.resetToken = resetToken;}
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public LocalDateTime getExpiresAt() {return expiresAt;}
    public void setExpiresAt(LocalDateTime expiresAt) {this.expiresAt = expiresAt;}
    public Boolean getUsed() {return used;}
    public void setUsed(Boolean used) {this.used = used;}
}
