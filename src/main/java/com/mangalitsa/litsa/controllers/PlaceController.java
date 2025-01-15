package com.mangalitsa.litsa.controllers;


import com.mangalitsa.litsa.controllers.model.PlacesRequest;
import com.mangalitsa.litsa.controllers.model.PlacesResponse;
import com.mangalitsa.litsa.services.PlaceService;
import com.mangalitsa.litsa.util.KeywordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/place")
public class PlaceController {

    private final PlaceService placesService;


    @Autowired
    public PlaceController(PlaceService placesService) {
        this.placesService = placesService;
    }

    @GetMapping
    public List<PlacesResponse> getNearbyPlaces(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam double radius,
            @RequestParam(required = false) List<String> keywords) {

        Set<String> includedTypes = new HashSet<>();
        if (keywords != null) {
            for (String keyword : keywords) {
                List<String> mappedTypes = KeywordMapper.getIncludedTypesForKeyword(keyword);
                includedTypes.addAll(mappedTypes);
            }
        }

        PlacesRequest requestDto = new PlacesRequest(
                latitude,
                longitude,
                radius,
                new ArrayList<>(includedTypes)
        );


        return placesService.getNearbyPlaces(requestDto);
    }
//    @GetMapping("/{id}")
//    public PlaceApiResponse getPlaceDetails(@PathVariable("id") String placeId) {
//        return placesService.getPlaceDetails(placeId);
//    }

}
