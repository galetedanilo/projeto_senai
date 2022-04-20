package com.galete.travel.mappers.tour.management;

import com.galete.travel.entities.postgres.Tour;
import com.galete.travel.requests.tour.management.TourManagementRequest;

import java.io.Serializable;

public class TourManagementMapper implements Serializable {

    private static final long serialVersionUID = 1L;

    public static void mapperTourManagementRequestToTour(TourManagementRequest tourManagementRequest, Tour tour) {
        tour.setImageUri(tourManagementRequest.getImageUri());
        tour.setCountry(tourManagementRequest.getCountry());
        tour.setDistrict(tourManagementRequest.getDistrict());
        tour.setDestination(tourManagementRequest.getDestination());
        tour.setIntroduction(tourManagementRequest.getIntroduction());
        tour.setDescription(tourManagementRequest.getDescription());
        tour.setCheckIn(tourManagementRequest.getCheckIn());
        tour.setCheckOut(tourManagementRequest.getCheckOut());
        tour.setPrice(tourManagementRequest.getPrice());
        tour.setPromotion(tourManagementRequest.getPromotion());
    }
}
