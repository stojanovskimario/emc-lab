package mk.ukim.finki.wp.emtlab.web.controller;

import mk.ukim.finki.wp.emtlab.model.dto.DisplayAccomodationCategorySummaryDto;
import mk.ukim.finki.wp.emtlab.service.application.AccomodationCategorySummaryViewApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accomodations/materialized-view")
public class AccomodationCategorySummaryViewController {
    private final AccomodationCategorySummaryViewApplicationService service;

    public AccomodationCategorySummaryViewController(AccomodationCategorySummaryViewApplicationService service) {
        this.service = service;
    }

    @GetMapping("/category-summary")
    public ResponseEntity<List<DisplayAccomodationCategorySummaryDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}

