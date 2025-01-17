package com.mangalitsa.litsa.services;

import com.mangalitsa.litsa.model.Favourites;

import java.util.List;
import java.util.Optional;

public interface FavouritesService {
    List<Favourites> getAllFavourites();
    void addFavourite(Favourites favouriteRequest);
    Optional<Favourites> deleteFavourite(String id);
}
