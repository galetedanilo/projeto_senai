package com.galete.travel.responses.tour.template;

import com.galete.travel.repositories.tour.projections.TourCardTemplateView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TourCardTemplateResponse extends RepresentationModel<TourCardTemplateResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String imageUri;
    private String country;
    private String district;
    private String destination;
    private String introduction;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private BigDecimal price;
    private Integer reviews;
    private Double stars;

    public TourCardTemplateResponse(TourCardTemplateView tourCardTemplateView) {
        this.id = tourCardTemplateView.getId();
        this.imageUri = tourCardTemplateView.getImageUri();
        this.country = tourCardTemplateView.getCountry();
        this.district = tourCardTemplateView.getDistrict();
        this.destination = tourCardTemplateView.getDestination();
        this.introduction = tourCardTemplateView.getIntroduction();
        this.checkIn = tourCardTemplateView.getCheckIn();
        this.checkOut = tourCardTemplateView.getCheckOut();
        this.price = tourCardTemplateView.getPrice();
        this.reviews = tourCardTemplateView.getReviews();
        this.stars = tourCardTemplateView.getStars();
    }
}
