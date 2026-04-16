package mk.ukim.finki.wp.emtlab.service.domain.impl;

import mk.ukim.finki.wp.emtlab.model.enums.Category;
import mk.ukim.finki.wp.emtlab.model.views.AccomodationView;
import mk.ukim.finki.wp.emtlab.repository.AccomodationViewRepository;
import mk.ukim.finki.wp.emtlab.service.domain.AccomodationViewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AccomodationViewServiceImpl implements AccomodationViewService {

	private final AccomodationViewRepository accomodationViewRepository;

	public AccomodationViewServiceImpl(AccomodationViewRepository accomodationViewRepository) {
		this.accomodationViewRepository = accomodationViewRepository;
	}

	@Override
	public Page<AccomodationView> findAll(
			int page,
			int size,
			String sortBy,
			String sortDirection,
			Category category,
			Long hostId,
			Long hostCountryId,
			Integer numRooms,
			Boolean rented,
			Boolean hasFreeRooms
	) {
		Boolean resolvedRented = resolveRented(rented, hasFreeRooms);
		Pageable pageable = PageRequest.of(page, size, Sort.by(resolveDirection(sortDirection), resolveSortBy(sortBy)));
		return accomodationViewRepository.findAllFiltered(category, hostId, hostCountryId, numRooms, resolvedRented, pageable);
	}

	private Boolean resolveRented(Boolean rented, Boolean hasFreeRooms) {
		if (rented != null) {
			return rented;
		}

		if (hasFreeRooms == null) {
			return null;
		}

		return !hasFreeRooms;
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
