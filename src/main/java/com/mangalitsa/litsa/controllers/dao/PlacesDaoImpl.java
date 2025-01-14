package com.mangalitsa.litsa.controllers.dao;

import com.mangalitsa.litsa.controllers.dto.PlacesRequest;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public class PlacesDaoImpl implements PlacesDao {



    @Override
    public String buildRequestBody(PlacesRequest request) {
        double latitude = request.getLatitude();
        double longitude = request.getLongitude();
        double radius = request.getRadius();
        List<String> includedTypes = request.getIncludedTypes();

        StringBuilder sb = new StringBuilder();
        sb.append("{");

        if (includedTypes != null && !includedTypes.isEmpty()) {
            sb.append("\"includedTypes\":[");
            for (int i = 0; i < includedTypes.size(); i++) {
                sb.append("\"")
                        .append(includedTypes.get(i))
                        .append("\"");
                if (i < includedTypes.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("],");
        }

        sb.append("\"locationRestriction\":{")
                .append("\"circle\":{")
                .append("\"center\":{")
                .append("\"latitude\":").append(latitude).append(",")
                .append("\"longitude\":").append(longitude)
                .append("},")
                .append("\"radius\":").append(radius)
                .append("}}}");


        return sb.toString();

    }
    }

