package com.mangalitsa.litsa.controllers.model;

import java.util.List;

public class PlacesResponse {
    private String id;
    private String displayName;
    private String photoLink;
    private String formattedAddress;
    private String website;
    private String priceLevel;
    private List<String> types;

    public PlacesResponse(String id, String displayName, String photoLink, String formattedAddress, String website, String priceLevel, List<String> types) {
        this.id = id;
        this.displayName = displayName;
        this.photoLink = photoLink;
        this.formattedAddress = formattedAddress;
        this.website = website;
        this.priceLevel = priceLevel;
        this.types = types;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(String priceLevel) {
        this.priceLevel = priceLevel;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}