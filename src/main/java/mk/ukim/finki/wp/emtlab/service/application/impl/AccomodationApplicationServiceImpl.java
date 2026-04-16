package mk.ukim.finki.wp.emtlab.service.application.impl;

import mk.ukim.finki.wp.emtlab.model.domain.Host;
import mk.ukim.finki.wp.emtlab.model.dto.CreateAccomodationDto;
import mk.ukim.finki.wp.emtlab.model.dto.DisplayAccomodationDto;
import mk.ukim.finki.wp.emtlab.model.enums.Category;
import mk.ukim.finki.wp.emtlab.service.application.AccomodationApplicationService;
import mk.ukim.finki.wp.emtlab.service.domain.AccomodationService;
import mk.ukim.finki.wp.emtlab.service.domain.HostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccomodationApplicationServiceImpl implements AccomodationApplicationService {

    private final AccomodationService accomodationService;
    private final HostService hostService;

    public AccomodationApplicationServiceImpl(AccomodationService accomodationService, HostService hostService) {
        this.accomodationService = accomodationService;
        this.hostService = hostService;
    }

    @Override
    public Optional<DisplayAccomodationDto> findById(Long id) {
        return accomodationService
            .findById(id)
            .map(DisplayAccomodationDto::from);
    }

    @Override
    public List<DisplayAccomodationDto> findAll() {
        return DisplayAccomodationDto.from(accomodationService.findAll());
    }

    @Override
    public Page<DisplayAccomodationDto> findAll(int page, int size, String sortBy, String sortDirection, Category category, Long hostId, Long hostCountryId, Integer numRooms, Boolean hasFreeRooms) {
        return accomodationService
                .findAll(PageRequest.of(page, size, Sort.by(resolveDirection(sortDirection), resolveSortBy(sortBy))), category, hostId, hostCountryId, numRooms, hasFreeRooms)
                .map(DisplayAccomodationDto::from);
    }

    @Override
    public List<DisplayAccomodationDto> findByRented(Boolean rented) {
        return DisplayAccomodationDto.from(accomodationService.findByRented(rented));
    }

    @Override
    public DisplayAccomodationDto create(CreateAccomodationDto createAccomodationDto) {
        Host host = hostService
            .findById(createAccomodationDto.hostId())
            .orElseThrow(() -> new RuntimeException("Host not found with id: " + createAccomodationDto.hostId()));
        return DisplayAccomodationDto.from(accomodationService.create(createAccomodationDto.toAccomodation(host)));
    }

    @Override
    public Optional<DisplayAccomodationDto> update(Long id, CreateAccomodationDto createAccomodationDto) {
        Host host = hostService
                .findById(createAccomodationDto.hostId())
                .orElseThrow(() -> new RuntimeException("Host not found with id: " + createAccomodationDto.hostId()));
        return accomodationService
                .update(id, createAccomodationDto.toAccomodation(host))
                .map(DisplayAccomodationDto::from);
    }

    @Override
    public Optional<DisplayAccomodationDto> deleteById(Long id) {
        return accomodationService
                .deleteById(id)
                .map(DisplayAccomodationDto::from);
    }

    @Override
    public Optional<DisplayAccomodationDto> toggleRented(Long id) {
        return accomodationService
                .toggleRented(id)
                .map(DisplayAccomodationDto::from);
    }

    private Sort.Direction resolveDirection(String sortDirection) {
        if (sortDirection == null || sortDirection.isBlank()) {
            return Sort.Direction.ASC;
        }

        try {
            return Sort.Direction.fromString(sortDirection);
        } catch (IllegalArgumentException exception) {
            return Sort.Direction.ASC;
        }
    }

    private String resolveSortBy(String sortBy) {
        if (sortBy == null || sortBy.isBlank()) {
            return "name";
        }

        return switch (sortBy) {
            case "name", "createdAt" -> sortBy;
            default -> "name";
        };
    }
}
