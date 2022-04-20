package com.galete.travel.responses.tour.management;

import com.galete.travel.controllers.tour.management.TourManagementController;
import com.galete.travel.entities.postgres.Tour;
import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TourManagementResponse extends RepresentationModel<TourManagementResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String imageUri;
    private String country;
    private String district;
    private String destination;
    private String introduction;
    private String description;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private BigDecimal price;
    private Instant createdAt;
    private Instant updatedAt;
    private Boolean promotion;

    public TourManagementResponse(Tour tour) {
        this.id = tour.getId();
        this.imageUri = tour.getImageUri();
        this.country = tour.getCountry();
        this.district = tour.getDistrict();
        this.destination = tour.getDestination();
        this.introduction = tour.getIntroduction();
        this.description = tour.getDescription();
        this.checkIn = tour.getCheckIn();
        this.checkOut = tour.getCheckOut();
        this.price = tour.getPrice();
        this.createdAt = tour.getCreatedAt();
        this.updatedAt = tour.getUpdatedAt();
        this.promotion = tour.getPromotion();

        this.add(WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(TourManagementController.class).findTourByPrimaryKey(id))
                .withSelfRel()
        );

        this.add(WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(TourManagementController.class).deleteTourByPrimaryKey(id))
                .withRel("Delete tour by primary key")
        );

        this.add(WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(TourManagementController.class).findAllTours(PageRequest.of(0, 10)))
                .withRel("Find all tours")
        );
    }
}
