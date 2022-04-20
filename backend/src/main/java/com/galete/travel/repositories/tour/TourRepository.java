package com.galete.travel.repositories.tour;

import com.galete.travel.entities.postgres.Tour;
import com.galete.travel.repositories.tour.projections.TourCardTemplateView;
import com.galete.travel.repositories.tour.projections.TourTableManagementView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

    Optional<TourCardTemplateView> findCardById(Long id);

    List<TourCardTemplateView> findByPromotion(Boolean isPromotion);

    @Query("SELECT tour.id AS id, tour.destination AS destination, tour.checkIn AS checkIn, tour.checkOut AS checkOut FROM Tour tour")
    Page<TourTableManagementView> findAllToursForTableManagement(Pageable pageable);


}
