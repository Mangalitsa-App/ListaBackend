package com.mangalitsa.litsa.controllers.dto;

import java.util.List;

public class PlacesRequest {
    private double latitude;
    private double longitude;
    private double radius;
    private List<String> includedTypes;

    public PlacesRequest() {
    }

    public PlacesRequest(double latitude, double longitude, double radius, List<String> includedTypes) {

        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.includedTypes = includedTypes;
    }



    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public List<String> getIncludedTypes() {
        return includedTypes;
    }

    public void setIncludedTypes(List<String> includedTypes) {
        this.includedTypes = includedTypes;
    }
}