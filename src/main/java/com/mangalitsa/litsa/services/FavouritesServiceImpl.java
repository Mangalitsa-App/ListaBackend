package com.mangalitsa.litsa.services;

import com.mangalitsa.litsa.model.Favourites;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavouritesServiceImpl implements FavouritesService {
    @Override
    public List<Favourites> getAllFavourites() {
        return List.of();
    }

    @Override
    public void addFavourite(Favourites favouriteRequest) {
    }

    @Override
    public Optional<Favourites> deleteFavourite(String id) {
        return Optional.empty();
    }
}
