package com.mangalitsa.litsa.services;

import com.mangalitsa.litsa.controllers.model.PlacesRequest;
import com.mangalitsa.litsa.controllers.model.PlacesResponse;
import com.mangalitsa.litsa.services.googleapimodel.Place;
import com.mangalitsa.litsa.services.googleapimodel.PlacesApiResponse;
import com.mangalitsa.litsa.services.googleapimodel.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final RequestBody requestBody;
    private final WebClient webClient;
    private static final String BASE_URL = "https://places.googleapis.com/v1/places:searchNearby";



    @Value("${google.places.api.key}")
    private String apiKey;
    @Autowired
    public PlaceServiceImpl(RequestBody requestBody, WebClient.Builder webclient) {
        this.requestBody = requestBody;
        this.webClient = webclient
                .baseUrl(BASE_URL)
                .build();
    }


    @Override
    public List<PlacesResponse> getNearbyPlaces(PlacesRequest placesRequest) {
        String request = requestBody.buildRequestBody(placesRequest);


        PlacesApiResponse response = webClient.post()
               .uri(UriBuilder::build)
                .header("Content-Type", "application/json")
                .header("X-Goog-Api-Key", apiKey)
                .header("X-Goog-FieldMask", "places.displayName,places.id,places.formattedAddress," +
                        "places.websiteUri,places.priceLevel,places.types,places.photos")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(PlacesApiResponse.class)
                .block();
        List<PlacesResponse> placesForEndpoint = new ArrayList<>();
        for(Place place : response.getPlaces()) {
            placesForEndpoint.add(new PlacesResponse(place.getId(),place.getDisplayName().getText(),
                    place.getPhotos().getFirst().getGoogleMapsUri(),
                    place.getFormattedAddress(),place.getWebsiteUri(),place.getPriceLevel(),place.getTypes()));
        }

        return placesForEndpoint;
    }

    @Override
    public PlacesResponse getPlaceDetails(String placeId) {
        return null;
    }

}
