package mk.ukim.finki.wp.emtlab.web.controller;

import jakarta.validation.Valid;
import mk.ukim.finki.wp.emtlab.model.dto.CreateAccomodationDto;
import mk.ukim.finki.wp.emtlab.model.dto.DisplayAccomodationDto;
import mk.ukim.finki.wp.emtlab.model.enums.Category;
import mk.ukim.finki.wp.emtlab.service.application.AccomodationApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accomodations")
public class AccomodationController {

    private final AccomodationApplicationService accomodationApplicationService;

    public AccomodationController(AccomodationApplicationService accomodationApplicationService) {
        this.accomodationApplicationService = accomodationApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayAccomodationDto> findById(@PathVariable Long id) {
        return accomodationApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DisplayAccomodationDto>> findAll() {
        return ResponseEntity.ok(accomodationApplicationService.findAll());
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<DisplayAccomodationDto>> findAllPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestParam(required = false) Category category,
            @RequestParam(required = false) Long hostId,
            @RequestParam(required = false) Long hostCountryId,
            @RequestParam(required = false) Integer numRooms,
            @RequestParam(required = false) Boolean hasFreeRooms
    ) {
        return ResponseEntity.ok(
                accomodationApplicationService.findAll(
                        page,
                        size,
                        sortBy,
                        sortDirection,
                        category,
                        hostId,
                        hostCountryId,
                        numRooms,
                        hasFreeRooms
                )
        );
    }

    @GetMapping("/filter/rented")
    public ResponseEntity<List<DisplayAccomodationDto>> findByRented(@RequestParam Boolean rented) {
        return ResponseEntity.ok(accomodationApplicationService.findByRented(rented));
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayAccomodationDto> create(@RequestBody @Valid CreateAccomodationDto createProductDto) {
        return ResponseEntity.ok(accomodationApplicationService.create(createProductDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayAccomodationDto> update(
            @PathVariable Long id,
            @RequestBody @Valid CreateAccomodationDto createProductDto
    ) {
        return accomodationApplicationService
                .update(id, createProductDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayAccomodationDto> deleteById(@PathVariable Long id) {
        return accomodationApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/toggle-rented")
    public ResponseEntity<DisplayAccomodationDto> toggleRented(@PathVariable Long id) {
        return accomodationApplicationService
                .toggleRented(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
