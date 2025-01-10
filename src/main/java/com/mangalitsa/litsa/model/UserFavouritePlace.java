package com.mangalitsa.litsa.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_favourite_places", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "google_place_id"})
})
public class UserFavouritePlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "google_place_id", nullable = false)
    private String googlePlaceId;

    @Column(name = "added_at", nullable = false)
    private LocalDateTime addedAt = LocalDateTime.now();

    public UserFavouritePlace() {}

    public UserFavouritePlace(User user, String googlePlaceId) {
        this.user = user;
        this.googlePlaceId = googlePlaceId;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public String getGooglePlaceId() {return googlePlaceId;}
    public void setGooglePlaceId(String googlePlaceId) {this.googlePlaceId = googlePlaceId;}
    public LocalDateTime getAddedAt() {return addedAt;}
    public void setAddedAt(LocalDateTime addedAt) {this.addedAt = addedAt;}
}
