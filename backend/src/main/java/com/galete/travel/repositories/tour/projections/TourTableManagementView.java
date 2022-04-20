package com.galete.travel.repositories.tour.projections;

import java.time.LocalDate;

public interface TourTableManagementView {

    Long getId();
    String getDestination();
    LocalDate getCheckIn();
    LocalDate getCheckOut();
}
