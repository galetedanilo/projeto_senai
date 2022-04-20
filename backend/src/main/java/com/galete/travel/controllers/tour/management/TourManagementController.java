package com.galete.travel.controllers.tour.management;

import com.galete.travel.requests.tour.management.TourManagementRequest;
import com.galete.travel.responses.tour.management.TourManagementResponse;
import com.galete.travel.responses.tour.management.TourTableManagementResponse;
import com.galete.travel.services.tour.management.TourManagementService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;

@RestController
@RequestMapping(value = "/api/v1/management/tour")
@AllArgsConstructor
public class TourManagementController implements Serializable {

    private static final long serialVersionUID = 1L;

    private final TourManagementService tourManagementService;


    @GetMapping
    public ResponseEntity<Page<TourManagementResponse>> findAllTours(Pageable pageable) {
        Page<TourManagementResponse> tourManagementResponsePage = tourManagementService.findAllTours(pageable);

        return new ResponseEntity<>(tourManagementResponsePage, HttpStatus.OK);
    }

    @GetMapping(value = "/table")
    public ResponseEntity<Page<TourTableManagementResponse>> findAllToursForTableManagement(Pageable pageable) {
        Page<TourTableManagementResponse> tourTableTemplateResponsePage = tourManagementService.findAllToursForTableManagement(pageable);

        return new ResponseEntity<>(tourTableTemplateResponsePage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TourManagementResponse> findTourByPrimaryKey(@PathVariable Long id) {
        TourManagementResponse tourManagementResponse = tourManagementService.findTourByPrimaryKey(id);

        return new ResponseEntity<>(tourManagementResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TourManagementResponse> createNewTour(@Valid @RequestBody TourManagementRequest tourManagementRequest) {
        TourManagementResponse tourManagementResponse = tourManagementService.createNewTour(tourManagementRequest);

        return new ResponseEntity<>(tourManagementResponse, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TourManagementResponse> updateTourByPrimaryKey(@Valid @RequestBody TourManagementRequest tourManagementRequest, @PathVariable Long id) {
        TourManagementResponse tourManagementResponse = tourManagementService.updateTourByPrimaryKey(tourManagementRequest, id);

        return new ResponseEntity<>(tourManagementResponse, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTourByPrimaryKey(@PathVariable Long id) {
        tourManagementService.deleteTourByPrimaryKey(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
