package com.mangalitsa.litsa.services;

import com.mangalitsa.litsa.controllers.dto.PlacesApiResponse;
import com.mangalitsa.litsa.controllers.dto.PlacesRequest;

public interface PlacesService {
    PlacesApiResponse getNearbyPlaces(PlacesRequest request);
    PlacesApiResponse getPlaceDetails(String placeId);


}
