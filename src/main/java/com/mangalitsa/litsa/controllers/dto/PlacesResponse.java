package com.mangalitsa.litsa.controllers.dto;

public class PlacesResponse {
    private String requestBody;

    public PlacesResponse() {
    }

    public PlacesResponse(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }
}
