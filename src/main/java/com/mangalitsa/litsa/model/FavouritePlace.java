package com.mangalitsa.litsa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "favourite_places", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"place_name", "latitude", "longitude"})
})
public class FavouritePlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "place_name", nullable = false)
    private String placeName;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    public FavouritePlace() {}

    public FavouritePlace(String placeName, Double latitude, Double longitude) {
        this.placeName = placeName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getPlaceName() {return placeName;}
    public void setPlaceName(String placeName) {this.placeName = placeName;}
    public Double getLatitude() {return latitude;}
    public void setLatitude(Double latitude) {this.latitude = latitude;}
    public Double getLongitude() {return longitude;}
    public void setLongitude(Double longitude) {this.longitude = longitude;}
}
