package com.galete.travel.repositories.tour.projections;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface TourCardTemplateView {

    Long getId();
    String getImageUri();
    String getCountry();
    String getDistrict();
    String getDestination();
    String getIntroduction();
    LocalDate getCheckIn();
    LocalDate getCheckOut();
    BigDecimal getPrice();
    Integer getReviews();
    Double getStars();
}
