package com.galete.travel.controllers.tour.template;

import com.galete.travel.responses.tour.template.TourCardTemplateResponse;
import com.galete.travel.services.tour.template.TourTemplateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/template/tour/card")
@AllArgsConstructor
public class TourTemplateController implements Serializable {

    private static final long serialVersionUID = 1L;

    private final TourTemplateService tourTemplateService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TourCardTemplateResponse> findTourByPrimaryKeyForCardTemplate(@PathVariable Long id) {
        TourCardTemplateResponse tourCardTemplateResponse = tourTemplateService.findTourByPrimaryKeyForCardTemplate(id);

        return new ResponseEntity<>(tourCardTemplateResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/promotions")
    public ResponseEntity<List<TourCardTemplateResponse>> findAllToursInternationalPromotions() {
        List<TourCardTemplateResponse> tourCardTemplateResponseList = tourTemplateService.findAllToursInternationalPromotions();

        return new ResponseEntity<>(tourCardTemplateResponseList, HttpStatus.OK);
    }
}
