package com.mangalitsa.litsa.services;


import com.mangalitsa.litsa.controllers.model.PlacesRequest;
import com.mangalitsa.litsa.controllers.model.PlacesResponse;

import java.util.List;

public interface PlaceService {
    List<PlacesResponse> getNearbyPlaces(PlacesRequest placesRequest);


    PlacesResponse getPlaceDetails(String placeId);
}

