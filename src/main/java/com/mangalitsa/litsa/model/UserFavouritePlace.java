package com.mangalitsa.litsa.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_favourite_places")
public class UserFavouritePlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private FavouritePlace favouritePlace;

    @Column(name = "added_at", nullable = false)
    private LocalDateTime addedAt = LocalDateTime.now();

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public FavouritePlace getFavouritePlace() {return favouritePlace;}
    public void setFavouritePlace(FavouritePlace favouritePlace) {this.favouritePlace = favouritePlace;}
    public LocalDateTime getAddedAt() {return addedAt;}
    public void setAddedAt(LocalDateTime addedAt) {this.addedAt = addedAt;}
}
