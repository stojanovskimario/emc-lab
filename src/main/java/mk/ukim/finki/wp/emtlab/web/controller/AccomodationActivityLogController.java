package mk.ukim.finki.wp.emtlab.web.controller;

import mk.ukim.finki.wp.emtlab.model.dto.DisplayAccomodationActivityLogDto;
import mk.ukim.finki.wp.emtlab.service.application.AccomodationActivityLogApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accomodations/activity-log")
public class AccomodationActivityLogController {
    private final AccomodationActivityLogApplicationService service;

    public AccomodationActivityLogController(AccomodationActivityLogApplicationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<DisplayAccomodationActivityLogDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "eventTime") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDirection
    ) {
        return ResponseEntity.ok(service.findAll(page, size, sortBy, sortDirection));
    }
}

