package mk.ukim.finki.wp.emtlab.service.application.impl;

import mk.ukim.finki.wp.emtlab.model.dto.DisplayAccomodationActivityLogDto;
import mk.ukim.finki.wp.emtlab.service.application.AccomodationActivityLogApplicationService;
import mk.ukim.finki.wp.emtlab.service.domain.AccomodationActivityLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AccomodationActivityLogApplicationServiceImpl implements AccomodationActivityLogApplicationService {
    private final AccomodationActivityLogService service;

    public AccomodationActivityLogApplicationServiceImpl(AccomodationActivityLogService service) {
        this.service = service;
    }

    @Override
    public Page<DisplayAccomodationActivityLogDto> findAll(int page, int size, String sortBy, String sortDirection) {
        return service.findAll(PageRequest.of(page, size, Sort.by(resolveDirection(sortDirection), resolveSortBy(sortBy))))
                .map(DisplayAccomodationActivityLogDto::from);
    }

    private Sort.Direction resolveDirection(String sortDirection) {
        if (sortDirection == null || sortDirection.isBlank()) {
            return Sort.Direction.DESC;
        }

        try {
            return Sort.Direction.fromString(sortDirection);
        } catch (IllegalArgumentException exception) {
            return Sort.Direction.DESC;
        }
    }

    private String resolveSortBy(String sortBy) {
        if (sortBy == null || sortBy.isBlank()) {
            return "eventTime";
        }

        return switch (sortBy) {
            case "id", "accomodationName", "eventTime", "eventType" -> sortBy;
            default -> "eventTime";
        };
    }
}

