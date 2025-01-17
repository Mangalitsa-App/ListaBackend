package com.mangalitsa.litsa.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class FavouritesControllerTest {

    private FavouritesController favouritesController;

    @BeforeEach
    void setUp() {
        favouritesController = new FavouritesController();
    }

    @Test
    void getFavourites() {
        var expected = emptyList();
        var result = favouritesController.getFavourites();
        assertThat(result).isEqualTo(expected);
    }
//
//    @Test
//    void getFavourite() {
//        FavouriteResponse expected = null;
//        var result = favouritesController.getFavourite("some_id");
//        assertThat(result).isEqualTo(expected);
//    }
//
//    @Test
//    void addFavourite() {
//        FavouriteResponse expected = null;
//        var requestBody = new FavouriteRequest("some_place_id");
//        var result = favouritesController.addFavourite(requestBody);
//        assertThat(result).isEqualTo(expected);
//    }
//
//    @Test
//    void deleteFavourite() {
//        String favouriteId = "some_id";
//        favouritesController.deleteFavourite(favouriteId);
//    }
}