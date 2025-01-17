package com.mangalitsa.litsa.services;

import com.mangalitsa.litsa.model.Favourites;

import java.util.List;

public interface FavouritesService {
    List<Favourites> getAllFavourites();
    void addFavourite(Favourites favouriteRequest);
    void deleteFavourite(String id);
}
