package com.galete.travel.responses.tour.management;

import com.galete.travel.controllers.tour.management.TourManagementController;
import com.galete.travel.controllers.tour.template.TourTemplateController;
import com.galete.travel.repositories.tour.projections.TourTableManagementView;
import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TourTableManagementResponse extends RepresentationModel<TourTableManagementResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String destination;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public TourTableManagementResponse(TourTableManagementView tourTableManagementView) {
        this.id = tourTableManagementView.getId();
        this.destination = tourTableManagementView.getDestination();
        this.checkIn = tourTableManagementView.getCheckIn();
        this.checkOut = tourTableManagementView.getCheckOut();

        this.add(
            WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(TourManagementController.class)
                    .findAllToursForTableManagement(PageRequest.of(0, 20)))
                .withRel("Find all tours for table managements")
        );

        this.add(
                WebMvcLinkBuilder
                    .linkTo(WebMvcLinkBuilder.methodOn(TourManagementController.class)
                        .findTourByPrimaryKey(this.id))
                    .withRel("Find by id to management")
        );

        this.add(
            WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(TourTemplateController.class)
                    .findTourByPrimaryKeyForCardTemplate(this.id))
                .withSelfRel()
        );
    }
}
