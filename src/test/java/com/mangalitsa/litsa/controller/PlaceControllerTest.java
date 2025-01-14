package com.mangalitsa.litsa.controller;

import com.mangalitsa.litsa.controllers.PlaceController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class PlaceControllerTest {

    private PlaceController placeController;

    @BeforeEach
    void setUp() {
        placeController = new PlaceController();
    }

    @Test
    void getPlaces() {
        List<PlaceResponse> expected = List.of(new PlaceResponse("some_id", "a name"));

        List<PlaceResponse> result = placeController.getPlaces(
                "location",
                1,
                null
        );

        assertThat(result).isEqualTo(expected);
    }
}