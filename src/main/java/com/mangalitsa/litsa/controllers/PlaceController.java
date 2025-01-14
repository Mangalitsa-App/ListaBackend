package com.mangalitsa.litsa.controllers;

import com.mangalitsa.litsa.controllers.dto.PlacesApiResponse;
import com.mangalitsa.litsa.controllers.dto.PlacesRequest;
import com.mangalitsa.litsa.services.PlacesService;
import com.mangalitsa.litsa.util.KeywordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/place")
public class PlaceController {

    private final PlacesService placesService;


    @Autowired
    public PlaceController(PlacesService placesService) {
        this.placesService = placesService;
    }

    @GetMapping
    public PlacesApiResponse getNearbyPlaces(
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

}
