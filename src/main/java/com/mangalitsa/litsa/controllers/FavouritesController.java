package com.mangalitsa.litsa.controllers;

import com.mangalitsa.litsa.model.Favourites;
import com.mangalitsa.litsa.services.FavouritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/favourites")
public class FavouritesController {

    private final FavouritesService favouritesService;

    @Autowired
    public FavouritesController(FavouritesService favouritesService) {
        this.favouritesService = favouritesService;
    }

    @GetMapping
    public ResponseEntity<List<Favourites>> getFavourites() {
        List<Favourites> favourites = favouritesService.getAllFavourites();
        if (favourites.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(favourites);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HttpStatus addFavourite(@RequestBody Favourites body) {
        favouritesService.addFavourite(body);
        return HttpStatus.CREATED;

    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteFavourite(@PathVariable String id) {
        favouritesService.deleteFavourite(id);
        return HttpStatus.NO_CONTENT;
    }

}
