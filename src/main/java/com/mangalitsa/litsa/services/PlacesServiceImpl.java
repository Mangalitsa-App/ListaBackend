package com.mangalitsa.litsa.services;

import com.mangalitsa.litsa.controllers.dao.PlacesDao;
import com.mangalitsa.litsa.controllers.dto.PlaceApiResponse;
import com.mangalitsa.litsa.controllers.dto.PlacesApiResponse;
import com.mangalitsa.litsa.controllers.dto.PlacesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;


@Service
public class PlacesServiceImpl implements PlacesService {
//TODO: CLEAN AND RESTRUCTURE THE CODE, PROTECT KEYS

    private final PlacesDao placesDao;
    private static final String BASE_URL = "https://places.googleapis.com/v1/places:searchNearby";
    private final WebClient webClient;


    @Autowired
    public PlacesServiceImpl(PlacesDao placesDao, WebClient.Builder webClientBuilder) {
        this.placesDao = placesDao;
        this.webClient = webClientBuilder
                .baseUrl(BASE_URL)
                .build();
    }

    @Override
    public PlacesApiResponse getNearbyPlaces(PlacesRequest request) {

        String requestBody = placesDao.buildRequestBody(request);

        String apiKey = "AIzaSyC1jZ-g7RoxlkO3Qf4ulH_e4hOHsrD4n20";


        return webClient.post()
                .uri(UriBuilder::build)
                .header("Content-Type", "application/json")
                .header("X-Goog-Api-Key", apiKey)
                .header("X-Goog-FieldMask", "places.displayName,places.id,places.formattedAddress," +
                        "places.websiteUri,places.priceLevel,places.types")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(PlacesApiResponse.class)
                .block();
    }

    @Override
    public PlaceApiResponse getPlaceDetails(String placeId) {
        String apiKey = "AIzaSyC1jZ-g7RoxlkO3Qf4ulH_e4hOHsrD4n20";
        PlaceApiResponse response = webClient.get()
                .uri("https://places.googleapis.com/v1/places/{placeId}", placeId)
                .header("X-Goog-Api-Key", apiKey)
                .header("X-Goog-FieldMask", "id,displayName")
                .retrieve()
                .bodyToMono(PlaceApiResponse.class)
                .block();
        return response;
    }


}

