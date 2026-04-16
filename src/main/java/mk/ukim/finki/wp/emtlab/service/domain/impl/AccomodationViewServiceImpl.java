package mk.ukim.finki.wp.emtlab.service.domain.impl;

import mk.ukim.finki.wp.emtlab.model.views.AccomodationView;
import mk.ukim.finki.wp.emtlab.repository.AccomodationViewRepository;
import mk.ukim.finki.wp.emtlab.service.domain.AccomodationViewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
			String sortDirection
	) {
		return accomodationViewRepository.findAll(
				PageRequest.of(page, size, Sort.by(resolveDirection(sortDirection), resolveSortBy(sortBy)))
		);
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
			case "id", "name", "category", "numRooms", "hostFullName", "countryName" -> sortBy;
			default -> "name";
		};
	}
}
