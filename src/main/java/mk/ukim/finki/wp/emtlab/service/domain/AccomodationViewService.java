package mk.ukim.finki.wp.emtlab.service.domain;

import mk.ukim.finki.wp.emtlab.model.enums.Category;
import mk.ukim.finki.wp.emtlab.model.views.AccomodationView;
import org.springframework.data.domain.Page;

public interface AccomodationViewService {
	Page<AccomodationView> findAll(
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
