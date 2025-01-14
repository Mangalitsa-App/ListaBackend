package com.mangalitsa.litsa.controllers.dao;

import com.mangalitsa.litsa.controllers.dto.PlacesRequest;

public interface PlacesDao {
    String buildRequestBody(PlacesRequest request);
}
