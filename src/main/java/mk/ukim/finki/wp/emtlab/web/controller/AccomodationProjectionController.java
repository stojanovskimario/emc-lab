package mk.ukim.finki.wp.emtlab.web.controller;

import mk.ukim.finki.wp.emtlab.model.projection.AccomodationExtendedProjection;
import mk.ukim.finki.wp.emtlab.model.projection.AccomodationShortProjection;
import mk.ukim.finki.wp.emtlab.service.application.AccomodationProjectionApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accomodations/projections")
public class AccomodationProjectionController {

    private final AccomodationProjectionApplicationService accomodationProjectionApplicationService;

    public AccomodationProjectionController(AccomodationProjectionApplicationService accomodationProjectionApplicationService) {
        this.accomodationProjectionApplicationService = accomodationProjectionApplicationService;
    }

    @GetMapping("/short")
    public ResponseEntity<List<AccomodationShortProjection>> findAllShortProjected() {
        return ResponseEntity.ok(accomodationProjectionApplicationService.findAllShortProjected());
    }

    @GetMapping("/extended")
    public ResponseEntity<List<AccomodationExtendedProjection>> findAllExtendedProjected() {
        return ResponseEntity.ok(accomodationProjectionApplicationService.findAllExtendedProjected());
    }
}

