package com.galete.travel.services.tour.template;

import com.galete.travel.helpers.enums.ApplicationExceptionEnums;
import com.galete.travel.repositories.tour.TourRepository;
import com.galete.travel.repositories.tour.projections.TourCardTemplateView;
import com.galete.travel.responses.tour.template.TourCardTemplateResponse;
import com.galete.travel.services.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TourTemplateService implements Serializable {

    private static final long serialVersionUID = 1L;

    private final TourRepository tourRepository;


    @Transactional(readOnly = true)
    public TourCardTemplateResponse findTourByPrimaryKeyForCardTemplate(Long id) {
        Optional<TourCardTemplateView> tourCardViewOptional = tourRepository.findCardById(id);

        TourCardTemplateView tourCardTemplateView = tourCardViewOptional.orElseThrow(() -> {
            return new ResourceNotFoundException(
                    String.format("Tour card by primary key %d does not exist", id),
                    ApplicationExceptionEnums.TOUR_NOT_FOUND
            );
        });

        return new TourCardTemplateResponse(tourCardTemplateView);
    }

    @Transactional(readOnly = true)
    public List<TourCardTemplateResponse> findAllToursInternationalPromotions() {
        List<TourCardTemplateView> tourCardTemplateViewList = tourRepository.findByPromotion(true);

        return  tourCardTemplateViewList.stream().map(obj -> new TourCardTemplateResponse(obj)).collect(Collectors.toList());
    }
}
