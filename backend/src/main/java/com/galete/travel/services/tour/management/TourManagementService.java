package com.galete.travel.services.tour.management;

import com.galete.travel.entities.postgres.Tour;
import com.galete.travel.helpers.enums.ApplicationExceptionEnums;
import com.galete.travel.mappers.tour.management.TourManagementMapper;
import com.galete.travel.repositories.tour.TourRepository;
import com.galete.travel.repositories.tour.projections.TourTableManagementView;
import com.galete.travel.requests.tour.management.TourManagementRequest;
import com.galete.travel.responses.tour.management.TourManagementResponse;
import com.galete.travel.responses.tour.management.TourTableManagementResponse;
import com.galete.travel.services.exceptions.IntegrityViolationException;
import com.galete.travel.services.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.time.Instant;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TourManagementService implements Serializable {

    private static final long serialVersionUID = 1L;

    private final TourRepository tourRepository;

    @Transactional(readOnly = true)
    public TourManagementResponse findTourByPrimaryKey(final Long id) {
        Optional<Tour> tourOptional = tourRepository.findById(id);

        Tour tour = tourOptional.orElseThrow(() -> {
            return new ResourceNotFoundException(
                    String.format("Tour by primary key %d does not exist", id),
                    ApplicationExceptionEnums.TOUR_NOT_FOUND
            );
        });

        return new TourManagementResponse(tour);
    }

    @Transactional(readOnly = true)
    public Page<TourTableManagementResponse> findAllToursForTableManagement(Pageable pageable) {

        Page<TourTableManagementView> tourTableTemplateViews= tourRepository.findAllToursForTableManagement(pageable);

        return tourTableTemplateViews.map(tour -> new TourTableManagementResponse(tour));
    }

    @Transactional(readOnly = true)
    public Page<TourManagementResponse> findAllTours(final Pageable pageable) {
        Page<Tour> tourPage = tourRepository.findAll(pageable);

        return tourPage.map(tour -> new TourManagementResponse(tour));
    }

    @Transactional
    public TourManagementResponse createNewTour(TourManagementRequest tourManagementRequest) {
        Tour tour = new Tour();
        Instant instant = Instant.now();

        TourManagementMapper.mapperTourManagementRequestToTour(tourManagementRequest, tour);

        tour.setCreatedAt(instant);
        tour.setUpdatedAt(instant);

        tour = tourRepository.save(tour);

        return new TourManagementResponse(tour);
    }

    @Transactional
    public TourManagementResponse updateTourByPrimaryKey(TourManagementRequest tourManagementRequest, Long id) {
        try {
            Tour tour = tourRepository.getById(id);

            TourManagementMapper.mapperTourManagementRequestToTour(tourManagementRequest, tour);

            tour.setUpdatedAt(Instant.now());

            tour = tourRepository.save(tour);

            return new TourManagementResponse(tour);
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException(
                    String.format("Tour by primary key %d does not exist", id),
                    ApplicationExceptionEnums.TOUR_NOT_FOUND);
        }
    }

    public void deleteTourByPrimaryKey(final Long id) {
        try {
            tourRepository.deleteById(id);
        } catch (DataIntegrityViolationException ex) {
            throw new IntegrityViolationException(
                    String.format("Integrity violation, unable to remove tour by primary key %d", id),
                    ApplicationExceptionEnums.TOUR_INTEGRITY_VIOLATION);
        }catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException(
                    String.format("Tour by primary key %d does not exist", id),
                    ApplicationExceptionEnums.TOUR_NOT_FOUND);
        }
    }

}
