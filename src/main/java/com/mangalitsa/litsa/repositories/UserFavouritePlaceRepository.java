package com.mangalitsa.litsa.repositories;

import com.mangalitsa.litsa.model.UserFavouritePlace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFavouritePlaceRepository extends CrudRepository<UserFavouritePlace, Long> {
}
