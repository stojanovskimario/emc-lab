package mk.ukim.finki.wp.emtlab.service.application.impl;

import mk.ukim.finki.wp.emtlab.model.dto.DisplayAccomodationViewDto;
import mk.ukim.finki.wp.emtlab.model.enums.Category;
import mk.ukim.finki.wp.emtlab.service.application.AccomodationViewApplicationService;
import mk.ukim.finki.wp.emtlab.service.domain.AccomodationViewService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AccomodationViewApplicationServiceImpl implements AccomodationViewApplicationService {

	private final AccomodationViewService accomodationViewService;

	public AccomodationViewApplicationServiceImpl(AccomodationViewService accomodationViewService) {
		this.accomodationViewService = accomodationViewService;
	}

	@Override
	public Page<DisplayAccomodationViewDto> findAll(
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
		return accomodationViewService
				.findAll(page, size, sortBy, sortDirection, category, hostId, hostCountryId, numRooms, rented, hasFreeRooms)
				.map(DisplayAccomodationViewDto::from);
	}
}
