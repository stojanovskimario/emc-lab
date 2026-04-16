package mk.ukim.finki.wp.emtlab.service.application;

import mk.ukim.finki.wp.emtlab.model.dto.DisplayAccomodationViewDto;
import mk.ukim.finki.wp.emtlab.model.enums.Category;
import org.springframework.data.domain.Page;

public interface AccomodationViewApplicationService {
	Page<DisplayAccomodationViewDto> findAll(
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
	);
}
