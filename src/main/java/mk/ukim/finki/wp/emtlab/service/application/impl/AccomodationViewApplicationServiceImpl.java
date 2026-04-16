package mk.ukim.finki.wp.emtlab.service.application.impl;

import mk.ukim.finki.wp.emtlab.model.dto.DisplayAccomodationViewDto;
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
			String sortDirection
	) {
		return accomodationViewService
				.findAll(page, size, sortBy, sortDirection)
				.map(DisplayAccomodationViewDto::from);
	}
}
